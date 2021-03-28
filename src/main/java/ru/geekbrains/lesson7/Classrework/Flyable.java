package ru.geekbrains.lesson7.Classrework;

public interface Flyable {
    //String s = "Some string";
    void fly(int length);
    void land();

    default void doDefolt() {
        System.out.println("DEFAULT");
    }

    static void doStatic() {
        System.out.println("STATIC!!!");
    }


}
