package ru.geekbrains.lesson5.homework;

public class Animal {
    protected String name;
    private static int qAnimal = 0;

    public Animal(String name) {
        this.name = name;
        qAnimal++;
    }

    protected void runAnimal(int length, int limit) {
        if (length <= limit)
            System.out.printf("%s пробежал %dм\n", this.name, length);
        else
            System.out.printf("%s не может пробежать %dм!\n", this.name, length);
    }

    protected void sweemAnimal(int length, int limit) {
        if (limit == 0) System.out.printf("%s не умеет плавать!\n", this.name);
        else {
            if (length <= limit)
                System.out.printf("%s проплыл %dм\n", this.name, length);
            else
                System.out.printf("%s не может проплыть %dм!\n", this.name, length);
        }
    }

    public static int getqAnimal() {
        return qAnimal;
    }
}
