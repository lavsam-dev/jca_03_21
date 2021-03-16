package ru.geekbrains.lesson5;

/**
 * Project jca_02_21
 *
 * Author Alexander Grigorev
 * Created 15.03.2021
 * v1.0
 */
public class Bird extends Animal {

    public Bird(String name, String color, int age) {
        super(name, color, age);
        this.type = "Bird";
    }

    @Override
    public void voice() {
        System.out.printf("Bird %s cheek cheereek!\n", this.name);
    }

    public void fly() {
        System.out.printf("Bird %s flying\n", this.name);
    }

}
