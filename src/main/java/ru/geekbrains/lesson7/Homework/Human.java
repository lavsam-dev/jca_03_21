package ru.geekbrains.lesson7.Homework;

public class Human implements Running, Jumping {
    private String name;
    private int maxRun;
    private int maxHeight;

    public Human(String name, int maxRun, int maxHeight) {
        this.maxRun = maxRun;
        this.maxHeight = maxHeight;
        this.name = name;
    }

    @Override
    public void run(int length) {
        System.out.printf("%s пробежал %dм\n", name, length);
    }

    @Override
    public void jump(int height) {
        System.out.printf("%s прыгнул на %dсм\n", name, height);
    }
}
