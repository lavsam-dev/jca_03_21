package ru.geekbrains.lesson8.Homework;

//import java.util.Scanner;

public class arraySum {
    int arrLen;

    public arraySum(int arrLen) {
        this.arrLen = arrLen;
    }

    public int summa(String[][] ar) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (ar.length != 4) throw new MyArraySizeException(ar.length);
        if (ar.length > 0 && ar[0].length != 4) throw new MyArraySizeException(ar[0].length);

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                try {
                    sum += Integer.parseInt(ar[i][j].trim());
                }
                catch (NumberFormatException nfe) {
                    throw new MyArrayDataException(i, j, ar[i][j], sum);
                }
            }
        }
        return sum;
    }
}

/*
                //System.out.printf("<%s> %d %d\n", ar[i][j], num, sum);
                int num = 0;
                try (Scanner s = new Scanner(ar[i][j])) {
                    while (s.hasNextInt()) {
                        num = s.nextInt();
                    }
                }
                catch (NumberFormatException nfe) {
                    System.out.println("NumberFormatExceptionScanner: " + nfe.getMessage());
                }
                sum += num;

 */