package ru.geekbrains.lesson14.Homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class OneAndFourTest {

    OneAndFour oneandfour = new OneAndFour();

    @CsvSource({
            "1 7@1 2 4 4 2 3 4 1 7",
            "1@1 1 1 4 4 1 4 1",
            "0@1 1 1 3 3 1 3 1",
    })
    @ParameterizedTest
    void after4(String sin) {
        String[] sar = sin.split("@");
        int[] arr4 = sToInt(sar[0]);
        int[] arr = sToInt(sar[1]);
        Assertions.assertArrayEquals(arr4, oneandfour.after4(arr));
        Assertions.assertThrows(RuntimeException.class, () -> oneandfour.after4(arr));
    }
    @CsvSource({
            "1 1 1 4 4 1 4 4",
            "1 1 1 1 1",
            "4 4 4 4",
            "1 4 4 1 1 4 3"
    })

    @ParameterizedTest
    void array1and4(String sarr) {
        int[] arr = sToInt(sarr);
        Assertions.assertTrue(oneandfour.array1and4(arr));
    }

    @Disabled
    @Test
    void  after4throw() {
        int[] arrThrow = new int[] {1, 2, 2, 3, 1, 7};
        int[] arr4 = new int[] {1, 7};
        Assertions.assertThrows(RuntimeException.class, () -> oneandfour.after4(arrThrow));
    }

    static int[] sToInt(String s) {
        String[] ss = s.split(" ");
        int[] arr = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        return arr;
    }
}