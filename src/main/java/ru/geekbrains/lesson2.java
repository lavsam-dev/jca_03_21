package ru.geekbrains;

import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

public class lesson2 {

    public static void main(String[] args) {
        int[] arrShift = {2, 4, 8, 16, 32, 64};
        System.out.println(Arrays.toString(arrShift));
        arrayShift1(arrShift, -4);
        System.out.println(Arrays.toString(arrShift));

        int[] arrShift2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(arrShift2));
        arrayShift1(arrShift2, 3);
        System.out.println(Arrays.toString(arrShift2));

        int[] arrShift3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(Arrays.toString(arrShift3));
        arrayShift1(arrShift3, 5);
        System.out.println(Arrays.toString(arrShift3));

    }
/*
В arrayShift1 был использован самый очевидный алгоритм сдвига на одну позицию,
повторяемый n раз.
В arrayShift2 была попытка использовать блочный алгоритм, но правильного решения
найти не удалось. Будем считать ее неудачной.
 */
    public static void arrayShift1(int arr[], int n){
        if(arr.length > 1) {
            for (int j = 0; j < Math.abs(n); j++) {
                if (n > 0){
                    int ab = arr[0];
                    for (int i = 0; i < arr.length - 1; i++) arr[i] = arr[i+1];
                    arr[arr.length-1] = ab;
                }
                else{
                    int ab = arr[arr.length-1];
                    for (int i = arr.length - 2; i >= 0; i--) arr[i+1] = arr[i];
                    arr[0] = ab;
                }
            }
        }
    }

    public static void arrayShift2(int arr[], int n){
        if(arr.length > 1){
            n %= arr.length;
            for (int j = 0; j < (arr.length - 1) / n; j++){
                int ab = arr[j];
                for (int i = j; i < arr.length; i += n){
                    if (i + n < arr.length) arr[i] = arr[i + n];
                    else arr[i] = ab;
                }
            }
        }
    }

    public static void arrEx(){
        int[] arr = new int[5];
        arr[0] = 5;
        arr[1] = 15;
        arr[2] = 43;
        arr[4] = 257;
        arr[3] = 512;

        int[] arr1 = {2, 4, 8, 16, 32, 64};
        String[] strings = {"Petr", "Vasily"};

        int[][] squareArr = new int[5][];
        squareArr[0] = new int[10];
        squareArr[1] = new int[20];
        System.out.println(squareArr[2][1]);

        int[][] square2 = {
                {1, 2, 3},
                {4},
                {9, 3, 34, 56}
        };

    }

    private static void loopEx(){
        for(int i = 0, j = 10; i < 100; j += 10, i++){
            System.out.println(i + " " + j);
        }

//        int i = 0;
//        do {
//            System.out.println(i++);
//        } while (i < 10);

        /*int j = 0;
        while (true){
            j++;
            int i = 0;
            while ((true)){
                System.out.print(++i + " ");
                if(i == 10){
                    System.out.println(" ");
                    break;
                }
            }
            if(j == 5) break;
        }*/

    }

    private static void switchEx(){
        String name = "Ivan1";
        switch (name){
            case "Petr":
                System.out.println("Put letter to Petr");
                break;
            case "Ivan":
                System.out.println("Put letter to Ivan");
                break;
            case "Vitaly":
                System.out.println("Put letter to Vitaly");
                break;
            case "Vasily":
                System.out.println("Put letter to Vasily");
                break;
            case "Alex":
                System.out.println("Put letter to Alex");
                break;
            default:
                System.out.println("Nothing");
        }
    }

    private static void rambling(){
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner in = new Scanner(System.in);
        //String as;
        //as = reader.readLine();
        //int num = in.nextInt();
//        byte[] bytes = {1, 2, 3, 4, 5, 12};
//        byte[] bytes1 = {1, 2, 3, 4, 5, 12};
//        byte[] copybytes = bytes;
//        System.out.println(bytes == copybytes);
//        System.out.println(Arrays.equals(bytes, bytes1));
//        System.out.println(Arrays.);
//        System.out.println(bytes);
//        System.out.println(bytes1);
//        System.out.println(Arrays.toString(bytes));

        byte b = 40;
        int i = 255;
        //i = b;
        //float f = i;
        b = (byte) i;
        //System.out.println(b);
/*
        for(byte b : bytes){
            System.out.println(++b);
        }
        for(byte b : bytes){
            System.out.println(--b);
        }

        for (int i = 0; i < bytes.length; i++){
            System.out.println(bytes[i]);
        }

        byte[][] byte2dArr = {
                {1,2,34},
                {4,6,7},
                {8,9,10}
        };

        for(byte[] bm : byte2dArr){
            for(byte b : bm){
                System.out.println(b);
            }
        }

        for(int i = 0; i < byte2dArr.length; i++){
            for(int j = 0; j < byte2dArr[i].length; j++){
                System.out.print(byte2dArr[i][j] + " ");
            }
            System.out.println();
        }*/

    }
}
