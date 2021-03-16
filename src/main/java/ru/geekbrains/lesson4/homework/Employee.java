package ru.geekbrains.lesson4.homework;

import java.util.SplittableRandom;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String name, String position, String email, String phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printToConsole() {
        System.out.printf("Name: %s Position: %s Email: %s Phone: %s Salary: $%.2f Age: %d\n",
                this.name, this.position, this.email, this.phone, this.salary, this.age);
    }

    public int getAge() {
        return age;
    }
}
