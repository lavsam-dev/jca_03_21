package ru.geekbrains.lesson5.homework;

public class Dog extends Animal {
    private static final int limitRun = 500;
    private static final int limitSwim = 10;
    private static int qDog = 0;

    public Dog(String name) {
        super(name);
        qDog++;
        System.out.printf("Это собака: %s\n", this.name);
    }

    public void Run(int length) {
        super.runAnimal(length, limitRun);
    }

    public void Sweem(int length) {
        super.sweemAnimal(length, limitSwim);
    }

    public static int getqDog() {
        return qDog;
    }
}
