package ru.geekbrains.lesson5;

/**
 * Project jca_02_21
 *
 * Author Alexander Grigorev
 * Created 15.03.2021
 * v1.0
 */
public class Dog extends Animal {
    String name;

    public Dog(String name, String color, int age) {
        super(name, color, age);
        this.type = "Dog";
    }

    @Override
    public void voice() {
        System.out.printf("Dog %s bark!\n", super.name);
    }

}
