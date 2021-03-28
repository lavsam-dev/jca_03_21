package ru.geekbrains.lesson7.Homework;

public class Robot implements Running, Jumping {
    private String name;
    private int maxRun;
    private int maxHeight;

    public Robot(String name, int maxRun, int maxHeight) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxHeight = maxHeight;
    }

    @Override
    public void jump(int height) {
        System.out.printf("%s прыгнул на %dсм\n", name, height);
    }

    @Override
    public void run(int length) {
        System.out.printf("%s пробежал %dм\n", name, length);
    }
}
