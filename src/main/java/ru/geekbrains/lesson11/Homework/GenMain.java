package ru.geekbrains.lesson11.Homework;

import java.util.ArrayList;
import java.util.Arrays;

public class GenMain {
    public static void main(String[] args) {
        Box<Apple> apples = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Orange> oranges = new Box<>(new Orange(), new Orange());
        Box<Apple> applesSecond = new Box<>(new Apple());
        Box<Fruit> fruits = new Box<>(new Fruit(4f));

        System.out.println(apples.getWeight());
        System.out.println(applesSecond.getWeight());
        System.out.println(oranges.getWeight());
        apples.putAllFruits(applesSecond);
        System.out.println(apples.getWeight());
        System.out.println(applesSecond.getWeight());
        System.out.println(apples.compareByWeight(applesSecond));
        System.out.println(applesSecond.compareByWeight(fruits));

        Integer[] arrEx = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arrEx));
        exchangeTwo(arrEx, 1, 3);
        System.out.println(Arrays.toString(arrEx));

        ArrayList<Integer> ari = arrayToList(arrEx);
        System.out.println(ari);

    }

    static void exchangeTwo(Object[] array, int index1, int index2) {
        Object work = array[index1];
        array[index1] = array[index2];
        array[index2] = work;
    }

    static <A> ArrayList<A> arrayToList (A[] array) {
        ArrayList<A> arrL = new ArrayList<>();
        for (A el: array) arrL.add(el);
        return arrL;
    }
}
