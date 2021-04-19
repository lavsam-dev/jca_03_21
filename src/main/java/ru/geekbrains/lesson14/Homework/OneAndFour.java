package ru.geekbrains.lesson14.Homework;

import java.util.ArrayList;
import java.util.Arrays;

public class OneAndFour {

    public int[] after4(int[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) if (arr[i] == 4) index = i;
        if (index < 0) throw new RuntimeException();

        int[] arrAfter4 = new int[arr.length - (++index)];
        if (arrAfter4.length >= 0)
            System.arraycopy(arr, index, arrAfter4, 0, arrAfter4.length);
        return arrAfter4;
    }

    public boolean array1and4(int[] arr) {
        boolean is1 = false;
        boolean is4 = false;

        for (int j : arr) {
            switch (j) {
                case 1:
                    is1 = true;
                    break;
                case 4:
                    is4 = true;
                    break;
                default:
                    return false;
            }
        }
        return is1 && is4;
    }
}
