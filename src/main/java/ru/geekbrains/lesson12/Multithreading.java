package ru.geekbrains.lesson12;

import java.util.Arrays;
import java.util.concurrent.*;

public class Multithreading {
    static int a = 0;
    static int b = 0;
    static int c = 0;
    static final Object mon = new Object();
    static final Object mon1 = new Object();
    static final Object mon2 = new Object();

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //        threadCreate();
//        interruptEx();
//        Thread t1 = new Thread(Multithreading::increment);
//        Thread t2 = new Thread(Multithreading::increment);
//        Thread t3 = new Thread(Multithreading::increment);
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//        t1.join();
//        t2.join();
//        t3.join();
//
//        System.out.printf("a = %d\nb = %d\nc = %d\n", a, b, c);
//System.arraycopy();
//        Arrays.equals();
        new Thread(Multithreading::doA).start();
        new Thread(Multithreading::doB).start();

        new Thread(() -> {
            System.out.println("Thread 1st level " + Thread.currentThread().getName());
            new Thread(() -> System.out.println("Thread 2nd level " + Thread.currentThread().getName())).start();
        }).start();

    }

    static void doA(){
        try {
            synchronized (mon1){
                System.out.println("Do A");
                Thread.sleep(4999);
            }
            doB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void doB() {
        try {
            synchronized (mon2)  {
                System.out.println("Do B");
                Thread.sleep(5000);
            }
            doA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static synchronized void increment() {
        for (int i = 0; i < 1000; i++) {
            synchronized (mon) {
                a++;
                b++;
                c++;
            }
        }
    }

    synchronized void doSomething() {
        for (int i = 0; i < 1000; i++) {

            synchronized (this) {
                a++;
                b++;
                c++;
            }
        }

    }

    private static void interruptEx() throws InterruptedException {
        int[] arr = {1, 2, 23, 4, 5, 6};
        Thread t = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Tick");
                    Thread.sleep(200);
//                    for (int i = 0; i < arr.length ; i++) {
//                        arr[i] *= 2;
//                        Thread.sleep(300);
//                    }
                    System.out.println("Tack");
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
//                    Thread.currentThread().interrupt();
//                    break;
            }
        });

//        t.setDaemon(true);
        t.start();

//        t.join();
//        t.join(2000);

//        System.out.println(Arrays.toString(arr));
        Thread.sleep(3000);
//        t.suspend();
//        t.resume();
//        t.stop();
        t.interrupt();
//        System.out.println("End of main!");
    }

    private static void threadCreate() throws InterruptedException, ExecutionException, TimeoutException {
        //        Thread
//        System.out.println("Hello world");
//
//        Thread.getAllStackTraces().forEach((k, v) -> System.out.println(k + "   " + v));
        System.out.printf("Hello from main Thread is [%s]\n", Thread.currentThread().getName());

        Thread t1 = new MyThread("My super Thread");
//        t1.run();
        t1.start();

        Thread t2 = new Thread(new MyRunnable());
        t2.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("Hello from anonymous! Thread is [%s]\n", Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> System.out.printf("Hello from lambda! Thread is [%s]\n",
                Thread.currentThread().getName())).start();

        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(15000);
                return "Hello from Callable!";
            }
        });

        new Thread(futureTask).start();

        System.out.println(futureTask.get(3, TimeUnit.SECONDS));
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.printf("Hello from MyRunnable! Thread is [%s]\n", Thread.currentThread().getName());
        }
    }

    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
//            start();
        }

        @Override
        public void run() {
            System.out.printf("Hello from MyThread! Thread is [%s]\n", Thread.currentThread().getName());
        }
    }
}
