package ru.geekbrains.lesson10.Homework;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        repeatWords();

        ArrayList<phonePers> phones = new ArrayList<>();
        phones.add(new phonePers("Robert Louis Stevenson", "+44 371 942 9999"));
        phones.add(new phonePers("Jim Hawkins", "+44 371 942 9345"));
        phones.add(new phonePers("Billy Bones", "+44 371 942 9567"));
        phones.add(new phonePers("Dr. David Livesey", "+44 371 942 4532"));
        phones.add(new phonePers("Squire John Trelawney", "+44 371 942 7845"));
        phones.add(new phonePers("Captain Alexander Smollett", "+44 371 942 8745"));
        phones.add(new phonePers("John Silver", "+44 371 942 9032"));
        phones.add(new phonePers("Ben Gunn", "+44 371 942 5603"));
        phones.add(new phonePers("Ben Gunn", "+44 371 942 5633"));
        phones.add(new phonePers("Ben Gunn", "+44 371 942 4503"));
        phones.add(new phonePers("Tom Redruth", "+44 371 942 2713"));
        phones.add(new phonePers("John Hunter", "+44 371 942 1095"));
        phones.add(new phonePers("Richard Joyce", "+44 371 942 4739"));
        phones.add(new phonePers("Abraham Gray", "+44 371 942 3693"));
        phones.add(new phonePers("Abraham Gray", "+44 371 956 3699"));
        phones.add(new phonePers("Job Anderson", "+44 371 942 6931"));
        phones.add(new phonePers("Israel Hands", "+44 371 942 5841"));
        phones.add(new phonePers("George Merry", "+44 371 942 3968"));
        phones.add(new phonePers("George Merry", "+44 371 942 3673"));
        phones.add(new phonePers("George Merry", "+44 371 942 3389"));
        phones.add(new phonePers("Tom Morgan", "+44 371 942 8844"));
        phones.add(new phonePers("O'Brien", "+44 371 942 9922"));

        System.out.println(phones);
        phones.sort(phonePers::compareTo);  // просто так...
        System.out.println(phones);

        findofName(phones, "George Merry");
        findofName(phones, "Robert Louis Stevenson");

    }

    private static void findofName(ArrayList<phonePers> phones, String findName) {
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).name == findName) {
                System.out.printf("%s", phones.get(i));
            }
        }
    }

    private static void repeatWords() {
        String[] words = new String[] {
                "есть", "пить", "гулять", "прыгать", "скакать", "конь", "топтать", "царапать", "залезать",
                "слезать", "ползти", "тапки", "гулять", "прыгать", "скакать", "царапать", "тапки", "гулять"
        };
        Set<String> setWords = new HashSet<>();
        System.out.printf("Слова...\n{");
        for (String s: words) {
            System.out.printf(s + ", ");
            setWords.add(s);
        }
        System.out.println("}\nУникальные слова:");
        System.out.println(setWords);
        System.out.println("Подсчет слов:");
        for (String sw: setWords) {
            int count = 0;
            for (String sa: words) if (sa.equals(sw)) count++;
            System.out.printf("%s(%d), ", sw, count);
        }
        System.out.println(" ");
    }
}

