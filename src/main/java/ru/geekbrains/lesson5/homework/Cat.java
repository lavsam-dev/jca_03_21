package ru.geekbrains.lesson5.homework;

public class Cat extends Animal {
    private static final int limitRun = 200;
    private static final int limitSwim = 0;
    private static int qCat = 0;

    public Cat(String name) {
        super(name);
        qCat++;
        System.out.printf("Это кот: %s\n", name);
    }

    public void Run(int length) {
        super.runAnimal(length, limitRun);
    }

    public void Sweem(int length) {
        super.sweemAnimal(length, limitSwim);
    }

    public static int getqCat() {
        return qCat;
    }
}
