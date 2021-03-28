package ru.geekbrains.lesson8.Homework;

public class MyArraySizeException extends Exception {

    private int number;

    public MyArraySizeException(int num) {
        //super(message);
        number=num;
    }

    public int getNumber() { return number; }
}
