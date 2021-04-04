package ru.geekbrains.lesson9.Homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
База данных с заметками и ярлычками к ним. К одной заметке может быть произвольное количество ярлычков.
Организация напоминает google keep. На примере заметок о котиках.
В файле "Имена для котиков.txt" хранятся ярлычки, то есть имена котиков.
В файле "Слова для котов.txt" хранятся слова для генерации заметок.
Для генерации заметок используется случайный выбор и hashset, чтобы исключить повторения слов.
В БД создаются три таблицы: заметки, ярлыки и связь между ними.
Пара запросов и удаление заметок.
 */
public class CatNotes {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;
    private static ArrayList<String> catListWords = new ArrayList<>();
    private static ArrayList<labels> catlistLabels = new ArrayList<>();
    private static int qNotes = 30; // кол-во записей в catnotes
    //private static int qLabels = 0;     // кол-во записей в catlabels - столько, сколько прочитано из файла
    //private static int qWordsInNote;    // кол-во слов в записи catnotes - случайно от 5 до 15
    //private static int qLabelsInNote;   // кол-во label для одной записи catnotes - случайно от 2 до 5

    public static void main(String[] args) throws FileNotFoundException, SQLException {

        prepareWords(false);

        try {
            connect();

            Scanner in = new Scanner(System.in);
            int choice = 0;
            do {
                System.out.println("Выберите:");
                System.out.println(">>>1 - генерировать базу данных");
                System.out.println(">>>2 - запрос по котикам и заметкам для них");
                System.out.println(">>>3 - запрос по заметкам и котикам");
                System.out.println(">>>4 - удалить заметку");
                System.out.println(">>>0 - закончить");

                choice = in.nextInt();
                switch (choice) {
                    case 0:
                        break;
                    case 1:
                        dropCreate(true);
                        long now = System.currentTimeMillis();
                        System.out.println("Генерация базы...");
                        createDB();
                        System.out.printf("База сгенерирована за: %d\n", System.currentTimeMillis() - now);
                        break;
                    case 2:
                        queryOne();
                        break;
                    case 3:
                        queryTwo();
                        break;
                    case 4:
                        deleteOne(in);
                        break;

                }
            } while (choice != 0);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void deleteOne(Scanner in) throws SQLException {
        ResultSet rsNote = statement.executeQuery("select * from catnotes");
        while (rsNote.next()) {
            System.out.printf("%2d <> %s\n", rsNote.getInt("id"), rsNote.getString("note"));
        }
        System.out.println("Введите номер заметки для удаления: (0 - выход)");
        int iDel = in.nextInt();
        if (iDel > 0) {
            try {
                connection.setAutoCommit(false);
                if (statement.executeUpdate("delete from catnotes where id = " + iDel) > 0) {
                    statement.executeUpdate("delete from catlinks where idnotes = " + iDel);
                }
            } catch (SQLException throwables) {
                connection.rollback();
            }
            connection.commit();
        }
    }

    private static void queryTwo() throws SQLException {
        System.out.println("----------------Заметки и участники----------------\n");
        Statement statement1 = connection.createStatement();
        ResultSet rsNote = statement.executeQuery("select * from catnotes");
        while (rsNote.next()) {
            System.out.printf("Заметка: %s\nКотики: ", rsNote.getString("note"));
            ResultSet rsCat = statement1.executeQuery("select label from catlabels, catlinks where catlabels.id = catlinks.idlabels and catlinks.idnotes = " + rsNote.getInt("id"));
            while (rsCat.next()) System.out.printf("#%s ", rsCat.getString("label"));
            System.out.printf("\n\n");
        }
        statement1.close();
    }

    private static void queryOne() throws SQLException {
        System.out.println("-------------Котики и заметки о них----------------\n");
        for (int i = 0; i < catlistLabels.size(); i++) {
            System.out.println("Кот: " + catlistLabels.get(i).getLabel());
            ResultSet rs = statement.executeQuery("select note from catlabels, catlinks, catnotes where catlabels.id = catlinks.idlabels and catlabels.label = '" + catlistLabels.get(i).getLabel() + "' and catlinks.idnotes = catnotes.id");
            while (rs.next()) {
                System.out.println("   " + rs.getString("note"));
            }
        }
    }

    private static void createDB() throws SQLException {
        int idLabels = 0;
        int idNotes = 0;

        for (int i = 0; i < catlistLabels.size(); i++) {
            statement.executeUpdate("insert into catlabels (label) values ('" + catlistLabels.get(i).getLabel() + "');");
        }
        ArrayList<labels> catList = new ArrayList<labels>(catlistLabels.size());

        for (int i = 0; i < qNotes; i++) {
            String note = "";
            Set<String>noteWords = new HashSet<>();
            int maxJ = rnd(5, 15);
            for (int j = 0; j < maxJ; j++) {
                while (!noteWords.add(catListWords.get(rnd(0, catListWords.size() - 1))));
            }
            for (String noteWord: noteWords) note += noteWord + " ";
            catList = (ArrayList<labels>) catlistLabels.clone();

            try {
                connection.setAutoCommit(false);
                statement.executeUpdate("insert into catnotes (note, meaning) values ('" + note + "', 0);");
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) idNotes = rs.getInt(1);
                maxJ = rnd(2, 5);
                for (int j = 0; j < maxJ; j++) {
                    idLabels = rnd(0, catList.size() - 1);
                    String sql = "insert into catlinks (idnotes, idlabels) values (" + idNotes + "," + (catList.get(idLabels).getIndex() + 1) + ");";
                    statement.executeUpdate(sql);
                    catList.remove(idLabels);
                }
            } catch (SQLException throwables) {
                connection.rollback();
            }
            connection.commit();
        }
    }

    private static void prepareWords(boolean print) throws FileNotFoundException {
        File fileCL = new File("Имена для котов.txt");
        Scanner cl = new Scanner(fileCL);
        int n = 0;
        while (cl.hasNext()) {
            catlistLabels.add(new labels(n++, cl.next()));
        }
        cl.close();
        if (print) {
            System.out.println(catlistLabels);
        }

        File fileCW = new File("Слова для котов.txt");
        Scanner cw = new Scanner(fileCW);
        while (cw.hasNext()) {
            catListWords.add(cw.next());
        }
        catListWords.size();
        cw.close();
        if (print) {
            System.out.println(catListWords);
        }
    }

    private static void dropCreate(boolean drop) throws SQLException {
        if (drop) {
            statement.execute("drop table if exists catnotes;");
            statement.execute("drop table if exists catlabels;");
            statement.execute("drop table if exists catlinks;");
        }
        statement.execute("create table if not exists catnotes (id integer primary key autoincrement, note text, meaning integer);");
        statement.execute("create table if not exists catlabels (id integer primary key autoincrement, label text);");
        statement.execute("create table if not exists catlinks (id integer primary key autoincrement, idnotes integer, idlabels integer);");
    }
    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:catlives.db");
        statement = connection.createStatement();
    }

    private static void disconnect() {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}

class labels {
    int index;
    String label;

    public labels(int index, String label) {
        this.index = index;
        this.label = label;
    }

    public int getIndex() {
        return index;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "котик{" +
                "i=" + index +
                ", имя='" + label + '\'' +
                '}';
    }
}



