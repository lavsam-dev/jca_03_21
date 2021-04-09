package ru.geekbrains.lesson11.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <F extends Fruit> {
    List<F> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public Box(List<F> fruits) {
        this.fruits = new ArrayList<>(fruits);
    }

    public Box(F... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    public void add(F fruit) {
        this.fruits.add(fruit);
    }

    public double getWeight() {
        double w = 0f;
        for (F f : fruits) w += f.getWeight();
        return w;
    }

    public List<F> getFruits() {
        return fruits;
    }

    public boolean compareByWeight(Box<? super F> second) {
        return Math.abs(this.getWeight() - second.getWeight()) < 0.00001;
    }

    public void putAllFruits(Box<F> second) {
        second.getFruits().addAll(fruits);
        fruits.clear();
    }
}
