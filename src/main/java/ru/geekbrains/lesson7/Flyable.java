package ru.geekbrains.lesson7;

/**
 * Project jca_02_21
 *
 * @Author Alexander Grigorev
 * Created 22.03.2021
 * v1.0
 */
//@FunctionalInterface
public interface Flyable {
    String s = "Some string";
    void fly(int length);
    void land();

    default void doDefault() {
        System.out.println("DEFAULT");
        //doPrivate();
    }

    static void doStatic() {
        System.out.println("STATIC!!!!");
    }

    /*private void doPrivate() {
        System.out.println("Private");
    }*/
}
