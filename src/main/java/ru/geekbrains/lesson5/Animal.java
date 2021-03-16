package ru.geekbrains.lesson5;

import java.util.Objects;

/**
 * Project jca_02_21
 *
 * Author Alexander Grigorev
 * Created 15.03.2021
 * v1.0
 */
public abstract class Animal extends Object {
    protected String name;
    protected String color;
    protected int age;
    protected String type;

    public Animal() {
    }

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void run() {
        System.out.printf("%s %s walking on its paws!\n",this.type, this.name);
    }

    public abstract void voice();

    @Override
    public String toString() {
        return String.format("Animal %s\nname: %s\ncolor: %s\nage: %d", this.type, this.name, this.color, this.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return age == animal.age &&
                Objects.equals(name, animal.name) &&
                Objects.equals(color, animal.color) &&
                Objects.equals(type, animal.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, age, type);
    }
}
