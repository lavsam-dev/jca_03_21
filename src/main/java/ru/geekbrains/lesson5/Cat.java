package ru.geekbrains.lesson5;

/**
 * Project jca_02_21
 *
 * Author Alexander Grigorev
 * Created 15.03.2021
 * v1.0
 */
public class Cat  extends Animal {

    public Cat(String name, String color, int age) {
        super(name, color, age);
        this.type = "Cat";
    }

    @Override
    public void voice() {
        System.out.printf("Cat %s meaw!\n", this.name);
    }

    @Override
    public void run() {
        System.out.println("Cat running");
    }
}

