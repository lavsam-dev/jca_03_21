package ru.geekbrains.lesson10.Homework;

public class phonePers implements Comparable<ru.geekbrains.lesson10.Homework.phonePers> {
    String name;
    String phone;

    public phonePers(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", phone='" + phone + '\'' + "\n";
    }

    @Override
    public int compareTo(ru.geekbrains.lesson10.Homework.phonePers o) {
        return name.compareTo(o.name);
    }
}

