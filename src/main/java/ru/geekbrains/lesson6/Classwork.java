package ru.geekbrains.lesson6;

import java.util.Random;
import java.util.Scanner;

/**
 * Project jca_02_21
 *
 * @Author Alexander Grigorev
 * Created 18.03.2021
 * v1.0
 */
public class Classwork {
    //hw 5
    //String
    //StringBuilder
    //Class
    //XO

    public static void main(String[] args) {
        Cat white = new Cat("MR. White", 100, 10);
        Cat black = new Cat("MR. Black", 75, 15);
        Random coin = new Random();
        int dice = coin.nextInt(2);
        if (dice == 0) {
            for (int i = 0; i < 10; i++) {
                if (white.getHealth() > 0) white.hit(black);
                else break;
                if (black.getHealth() > 0) black.hit(white);
                else break;
            }
        }
        if (dice == 1) {
            for (int i = 0; i < 10; i++) {
                if (black.getHealth() > 0) black.hit(white);
                else break;
                if (white.getHealth() > 0) white.hit(black);
                else break;
            }
        }

    }

    private static void cats() {
        Cat[] cats = {
                new Cat("Barsik", 5),
                new Cat("Murzik", 10),
                new Cat("Vaska", 15),
                new Cat("Cocos", 45)
        };

        AbstractBowl abstractBowl = new AbstractBowl() {
            String name;

            @Override
            public void decreaseFood(int amount) {
                super.decreaseFood(amount);
                System.out.println("Food decreased from anonymous bowl");
            }
        };

        CatBowl bowl = new CatBowl();
        bowl.putFood(45);
        AbstractBowl dish = new Dish();
        dish.putFood(100);
        AbstractBowl plate = new Plate();
        plate.putFood(70);
        abstractBowl.putFood(90);

//        Cat catBowl = new Cat("G", 10);
//        catBowl.putFood(40);

        for (Cat cat : cats) {
            cat.eat(bowl);
            cat.eat(dish);
            cat.eat(plate);
            cat.eat(abstractBowl);
//            cat.eat(catBowl);
        }

        System.out.println(bowl.getFood());
        System.out.println(dish.getFood());
        System.out.println(plate.getFood());
        System.out.println(abstractBowl.getFood());

        System.out.println(cats[0].getClass().getName());
        System.out.println(bowl.getClass().getName());
        System.out.println(dish.getClass().getName());
        System.out.println(plate.getClass().getName());
        System.out.println(abstractBowl.getClass().getName());
    }

    private static void stringBuilderExample() {
        String s1 = "Example";

        long startTime = System.nanoTime();

        for (int i = 0; i < 100_000; i++) {
            s1 += i;
        }
        float delta = (System.nanoTime() - startTime) * 0.000001f;
//        System.out.println(s1);
        System.out.println("String Delta: " + delta + " ms");


        StringBuilder sb = new StringBuilder("Example");
        startTime = System.nanoTime();

        for (int i = 0; i < 100_000; i++) {
            sb.append(i);
        }
        delta = (System.nanoTime() - startTime) * 0.000001f;
//        System.out.println(s1);
        System.out.println("String Builder Delta: " + delta + " ms");

        StringBuilder sb1 = new StringBuilder(100_009);
        sb1.append("Example");
        startTime = System.nanoTime();

        for (int i = 0; i < 100_000; i++) {
            sb1.append(i);
        }
        delta = (System.nanoTime() - startTime) * 0.000001f;
//        System.out.println(s1);
        System.out.println("String Builder+ Delta: " + delta + " ms");

        System.out.println(s1.equals(sb.toString()));
        System.out.println(s1.equals(sb1.toString()));
//
//        String s = new String("ldfknbldgjb");
//        s = null;
//StringBuffer
    }

    private static void stringsExample() {
        Scanner sc = new Scanner(System.in);
        String s1 = "Hello";
        String s2 = "Hello";
        String s12 = new String("Hello");
        String s3 = "Hel";
        String s4 = s3 + "lo";
        String s5 = sc.next();
        String s6 = new String(new char[]{'H', 'e', 'l', 'l', 'o'});
        String s7 = new String(s6);
        String s8 = new String(new byte[]{24, 42, 56, 86});

//        System.out.println(s1 == s2);
//        System.out.println(s1 == s4);
//        System.out.println(s1 == s5);
//        System.out.println(s1 == s6);
//        System.out.println(s1 == s12);

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s12));
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s5));
        System.out.println(s1.equals(s6));
        System.out.println(s1.equals(s7));
        System.gc();
    }
}
