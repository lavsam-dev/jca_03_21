package ru.geekbrains.lesson12.Homework;

public class ArrayThreads {
    static final int size = 10000000;
    static final int half = size / 2;
    static float[] arr = new float[size];
    static float[] arr1 = new float[half];
    static float[] arr2 = new float[half];

    public static void main(String[] args) {
        long timeBegin;

        for (int i = 0; i < size; i++) arr[i] = 1f;
        timeBegin = System.currentTimeMillis();
        arrayOneThread(arr);    // весь массив в одном потоке
        System.out.println("One thread: " + (System.currentTimeMillis() - timeBegin));

        for (int i = 0; i < size; i++) arr[i] = 1f;
        timeBegin = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr, half, arr2, 0, half);

        Runnable r1 = new arrayThreadRunnable(arr1);
        new Thread(r1).start();
        Runnable r2 = new arrayThreadRunnable(arr2);
        new Thread(r2).start();

        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);

        System.out.println("Two threads: " + (System.currentTimeMillis() - timeBegin));
    }

    private static class arrayThreadRunnable implements Runnable {
        float[] arr;

        public arrayThreadRunnable(float[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            int size = arr.length;
            for (int i = 0; i < size; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }

    private static void arrayOneThread(float[] arr) {

        int size = arr.length;
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
