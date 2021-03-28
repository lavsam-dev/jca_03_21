package ru.geekbrains.lesson8.Homework;

public class MyArrayDataException extends Exception {

    private int indexI;
    private int indexJ;
    private String elementArr;
    private int sum;

    public MyArrayDataException(int indexI, int indexJ, String elementArr, int sum) {
        this.indexI = indexI;
        this.indexJ = indexJ;
        this.elementArr = elementArr;
        this.sum = sum;
    }

    public int getIndexI() {
        return indexI;
    }

    public int getIndexJ() {
        return indexJ;
    }

    public String getElementArr() {
        return elementArr;
    }

    public int getSum() {
        return sum;
    }
}
