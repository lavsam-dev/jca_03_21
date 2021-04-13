package ru.geekbrains.lesson12.HomeworkAG;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayProcessing {
    static final int SIZE = 10_000_000;
    static final int ARRAYS_COUNT = 5;

    public static void main(String[] args) {

        float[] ethalonArr = new float[SIZE];

        float[][] arrays = new float[ARRAYS_COUNT][SIZE];

//        for (int i = 0; i < arrays.length; i++) {
//            arrays[i] = new float[SIZE];
//        }

        try {
            oneThreadProcessing(ethalonArr);
            for (int i = 0, j = 2; i < arrays.length; i++, j += 2) {
                multiThreadProcess(arrays[i], j);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (float[] arr : arrays) {
            System.out.println(Arrays.equals(ethalonArr, arr));
        }
    }


    public static void multiThreadProcess(float[] arr, int threads) throws InterruptedException {
        while (SIZE % threads != 0) {
            threads -= 1;
        }
//        if (SIZE % threads != 0) {
//            int temp = threads - (SIZE % threads);
//            System.out.printf("This number of threads - %d is incorrect, trying with %d\n", threads, temp);
//            threads = temp;
//        }

        System.out.printf("Starting... with %d threads", threads);
        long startTime = System.currentTimeMillis();
        Arrays.fill(arr, 1.0f);
        long timeToFill = (System.currentTimeMillis() - startTime);


        List<float[]> arrays = new LinkedList<>();
        int index = 0;
        int length = SIZE / threads;
        for (int i = 0; i < threads; i++) {
            float[] temp = new float[SIZE / threads];
            System.arraycopy(arr, index, temp, 0, length);
            index += length;
            arrays.add(temp);
        }


        List<Thread> threadsList = new LinkedList<>();
        long splitTime = (System.currentTimeMillis() - startTime - timeToFill);
        index = 0;
        for (int i = 0; i < arrays.size(); i++) {
            Thread t = new ArrayThread(arrays.get(i), index);
            index += length;
            t.start();
            threadsList.add(t);
        }

        for (Thread t : threadsList) t.join();

        long processingTime = (System.currentTimeMillis() - startTime - timeToFill - splitTime);

        index = 0;
        for (int i = 0; i < arrays.size(); i++) {
            System.arraycopy(arrays.get(i), 0, arr, index, length);
            index += length;
        }

        long joinTime = (System.currentTimeMillis() - startTime - timeToFill - splitTime - processingTime);

        System.out.println("Операция выполнена за " + (System.currentTimeMillis() - startTime) + " мс\nРазбивка массива " +
                +splitTime + " мс\nОбработка формулой " + processingTime + " мс\nСклейка массива " + joinTime + " мс\n\n");
    }

    public static void oneThreadProcessing(float[] arr) throws InterruptedException {
        System.out.println("Starting... with 1 thread");
        long startTime = System.currentTimeMillis();
        Arrays.fill(arr, 1.0f);

        long time1 = (System.currentTimeMillis() - startTime);

        ArrayThread thread1 = new ArrayThread(arr, 0);
        thread1.start();
        thread1.join();
        long time2 = (System.currentTimeMillis() - time1 - startTime);

        System.out.println("Операция выполнена за " + (System.currentTimeMillis() - startTime) + " мс\nЗаполнение единицами " + time1 + " мс\nОбработка формулой " + time2 + " мс\n\n");
    }

    static class ArrayThread extends Thread {
        private float[] arr;
        private int startIndex;

        public ArrayThread(float[] arr, int startIndex) {
            this.arr = arr;
            this.startIndex = startIndex;
        }

        @Override
        public void run() {
            for (int element = 0; element < this.arr.length; element++) {
                this.arr[element] = (float) (this.arr[element] * Math.sin(0.2f + (element + startIndex) / 5.0) * Math.cos(0.2f + (element + startIndex) / 5.0) * Math.cos(0.4f + (element + startIndex) / 2.0));
            }
        }

    }
}
