package ru.geekbrains.lesson1;
/*
    Домашнее задание по курсу Java Core для Android
    Сделал: Львов Андрей
 */
public class task1 {
    public static void main(String[] args) {
        System.out.println("Задача 1: вычисление выражения с плавающей точкой");
        System.out.println(funcAf(1, 2, 5, 3));
        System.out.println("Задача 2: сумма чисел от 10 до 20 включительно");
        System.out.println(funcAb(7, 2) + " " + funcAb(10, 5));
        System.out.println("Задача 3: положительное или отрицательное число");
        plusminus(-1);
        plusminus(2);
        System.out.println("Задача 4: Привет, Андрей");
        System.out.println(hello("Andy"));
        System.out.println("Задача 5: високосный ли год? (2100, 2000, 2020, 2021)");
        System.out.println(isLeapYear(2100));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2020));
        System.out.println(isLeapYear(2021));
    }

    private static float funcAf(int a, int b, int c, int d) {
        return (float)a * ((float)b + (float)c / (float)d);
    }

    private static boolean funcAb(int a, int b) {
        int c = a + b;
        return c >= 10 && c <= 20;
    }

    private static void plusminus(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    private static String hello(String name) {
        return "Привет, " + name + "!";
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
