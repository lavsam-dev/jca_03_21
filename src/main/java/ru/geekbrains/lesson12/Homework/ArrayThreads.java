package ru.geekbrains.lesson12.Homework;

public class ArrayThreads {
    private static final int size = 10_000_000;
    private static final int half = size / 2;
    private static float[] arrOne = new float[size];
    private static float[] arr1 = new float[half];
    private static float[] arr2 = new float[half];
    private static float[] arrTwo = new float[size];

    public static void main(String[] args) throws InterruptedException {
        long timeBegin;

        for (int i = 0; i < size; i++) arrOne[i] = 1f;
        timeBegin = System.currentTimeMillis();
        arrayOneThread(arrOne, 0);    // весь массив в одном потоке
        System.out.println("One thread: " + (System.currentTimeMillis() - timeBegin));

        for (int i = 0; i < size; i++) arrTwo[i] = 1f;
        timeBegin = System.currentTimeMillis();
        System.arraycopy(arrTwo, 0, arr1, 0, half);
        System.arraycopy(arrTwo, half, arr2, 0, half);

        Thread t1 = new Thread(() -> arrayOneThread(arr1, 0));
        Thread t2 = new Thread(() -> arrayOneThread(arr2, half));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Выполнение прервано");
            e.printStackTrace();
            return;
        }

        System.arraycopy(arr1, 0, arrTwo, 0, half);
        System.arraycopy(arr2, 0, arrTwo, half, half);
        System.out.println("Two threads: " + (System.currentTimeMillis() - timeBegin));
        System.out.println(arrayCompareEpsilon(arrOne, arrTwo));
    }

    private static void arrayOneThread(float[] arr, int offset) {

        int size = arr.length;
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + offset) / 5) * Math.cos(0.2f + (i + offset) / 5) * Math.cos(0.4f + (i + offset) / 2));
        }
    }

    private static String arrayCompareEpsilon(float[] arr1, float[] arr2) {
        long size = arr1.length;
        if (size != arr2.length) return "Size false";
        for (int i = 0; i < size; i++) {
            if (Math.abs(arr1[i] - arr2[i]) > 0.00001) return ("i = " + i + " arr1 = " + arr1[i] + " arr2 = " + arr2[i]);
        }
        return "Arrays equals";
    }
}
