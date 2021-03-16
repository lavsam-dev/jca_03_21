package ru.geekbrains.lesson5;

/**
 * Project jca_02_21
 *
 * Author Alexander Grigorev
 * Created 15.03.2021
 * v1.0
 */
public class Horse  extends Animal {

    public Horse(String name, String color, int age) {
        super(name, color, age);
        this.type = "Horse";
    }

    @Override
    public void voice() {
        System.out.printf("Horse %s igogo!\n", this.name);
    }

}
