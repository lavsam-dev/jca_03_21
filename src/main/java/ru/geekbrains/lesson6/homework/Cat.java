package ru.geekbrains.lesson6.homework;

import ru.geekbrains.lesson6.homework.Bowl;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Bowl bowl) {
        if (bowl.decreaseFood(this.appetite)) {
            this.fullness = true;
            System.out.printf("Кот %s съел из миски %d еды!\n", this.name, this.appetite);
        }
        else {
            this.fullness = false;
            System.out.printf("Коту %s не удалось поесть, он голоден!\n", this.name);
        }
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

}
