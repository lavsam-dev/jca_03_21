package ru.geekbrains.lesson9;

import java.sql.*;

public class DatabaseExample {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;
    private  static CallableStatement cs;

    public static void main(String[] args) {
        try {
            connect();
            dropCreate();
            prepareStatement();

//            cs = connection.prepareCall("{call insert_student(?, ?, ?)}");
//            cs.setString(1, "huuhuh");

            try {
                connection.setAutoCommit(false);
                statement.executeUpdate("insert into students (name, score) values ('Petya', 85);");
//                Savepoint savepoint = connection.setSavepoint();
                statement.executeUpdate("insert into students (name, score) values ('Vasya', 95);");
                //connection.rollback(savepoint);
//                connection.rollback();
                statement.executeUpdate("insert into students (name, score) values ('Jorik', 75);");
//                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                connection.rollback();
            }
            connection.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void readEx() throws SQLException {
        try (ResultSet rs = statement.executeQuery("select name, score from students where id > 20000 and id < 20020;")) {
            while (rs.next()) {
                System.out.printf("Student: %s >>>>>> %d\n", rs.getString("name"), rs.getInt(2));
            }
        }
    }

    private static void batchEx() throws SQLException {
        long now = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 0; i < 30_000; i++) {
            ps.setString(1, "Vasya_" + i);
            ps.setInt(2, i);
            ps.addBatch();
            //ps.executeUpdate();
        }
        try {
            ps.executeBatch();
        } catch (Exception throwables) {
            connection.rollback();
        }
        connection.commit();
        System.out.println(System.currentTimeMillis() - now);
    }

    private static void psinsertEx() throws SQLException {
        for (int i = 0; i < 30; i++) {
            ps.setString(1, "Vasya_" + i);
            ps.setInt(2, i * 10);
            ps.executeUpdate();
        }
    }

    private static void updateEx() throws SQLException {
        int upd1 = statement.executeUpdate("update students set name = 'John' where score > 200;");
        int upd2 = statement.executeUpdate("update students set score = 100500 where name > 'Vasya_0';");
        int upd3 = statement.executeUpdate("delete from students where name like 'Vasya%';");
        System.out.println("Updated: " + upd1);
    }

    private static void insertEx() throws SQLException {
        statement.executeUpdate("insert into students (name, score) values ('Petya', 85);");
    }

    private static void dropCreate() throws SQLException {
        statement.execute("drop table if exists students;");
        statement.execute("create table if not exists students (id integer primary key autoincrement, name text, score integer);");
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

    private static void prepareStatement() throws SQLException {
        ps = connection.prepareStatement("insert into students (name, score) values (?, ?);");
    }

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:students.db");
        statement = connection.createStatement();
    }
}
