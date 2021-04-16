package ru.geekbrains.lesson13;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MultithreadingSync {
    //Читать могут много потоков одновременно
    //Писать только 1 поток
    //Пока кто-то читает, никто не пишет
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        executors();
//        simpleLock();
//        reentrantLock();
//        cdl();
//        barrier();
//        barrierRunnable();
        semaphore();

        List<String> l1 = new ArrayList<>();
        List<String> l2 = new Vector<>();
        List<String> l3 = new CopyOnWriteArrayList<>();
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new CopyOnWriteArraySet<>();
        Map<String, String> m1 = new HashMap<>();
        Map<String, String> m2 = new Hashtable<>();
        Map<String, String> m3 = new ConcurrentHashMap<>();

    }

    private static void semaphore() {
        final Semaphore smp = new Semaphore(3, true);

        for (int i = 0; i < 10; i++) {
            int count = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + count + " before smp");
                    smp.acquire();
//                    smp.acquireUninterruptibly();
                    System.out.println("Thread " + count + " makes some long actions");
                    Thread.sleep((long) (200 * count + 500 * Math.random()));
                    System.out.println("Thread " + count + " end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    smp.release();
                }
            }).start();
        }
    }

    private static void barrierRunnable() {
        final int THREADS_COUNT = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREADS_COUNT, () -> System.out.println("Гонка началась!"));

        for (int i = 0; i < THREADS_COUNT; i++) {
            int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Гонщик  " + w + " готовится");
                    Thread.sleep((long) (2000 * w + 500 * Math.random()));
                    System.out.println("Гонщик  " + w + " готов, на линии старта");
                    cyclicBarrier.await();
                    System.out.println("Гонщик  " + w + " поехал");
                    cyclicBarrier.await();

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void barrier() {
        final int THREADS_COUNT = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREADS_COUNT + 1);

        for (int i = 0; i < THREADS_COUNT; i++) {
            int w = i;
            new Thread(() -> {
                try {
                    System.out.println("Гонщик  " + w + " готовится");
                    Thread.sleep((long) (2000 * w + 500 * Math.random()));
                    System.out.println("Гонщик  " + w + " готов, на линии старта");
                    cyclicBarrier.await();
                    System.out.println("Гонщик  " + w + " поехал");
                    cyclicBarrier.await();
//                    cyclicBarrier.reset();

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        try {
//            Thread.sleep(7000);
            while (cyclicBarrier.getNumberWaiting() != THREADS_COUNT) {
                Thread.sleep(300);
            }
            System.out.println("Гонка началась!");
            cyclicBarrier.await();

            while (cyclicBarrier.getNumberWaiting() != THREADS_COUNT) {
                Thread.sleep(300);
            }
            System.out.println("Гонка закончилась!");
            cyclicBarrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void cdl() {
        final int THREADS_COUNT = 20;

        final CountDownLatch cdl = new CountDownLatch(THREADS_COUNT + 1);
        System.out.println("Start!");
        for (int i = 0; i < THREADS_COUNT; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    Thread.sleep((long) (200 * w + 500 * Math.random()));
                    System.out.println("Thread " + w + " ready");
                    cdl.countDown();
                    cdl.await();
//                    cdl.
                    System.out.println("Go!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
//                    cdl.countDown();
//                    System.out.println(cdl.getCount());
//                    cdl.await();
                }
            }).start();
        }

        try {
            while (cdl.getCount() != 1) {
                Thread.sleep(200);
            }
            cdl.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("End");
    }

    private static void reentrantLock() {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

        new Thread(() -> {
            try {
                rwl.readLock().lock();
                System.out.println("Read start lock 1");
                Thread.sleep(2000);
                System.out.println("Reading lock 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("End read lock 1");
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                rwl.readLock().lock();
                System.out.println("Read start lock 2");
                Thread.sleep(3000);
                System.out.println("Reading lock 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("End read lock 2");
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                rwl.readLock().lock();
                System.out.println("Read start lock 3");
                Thread.sleep(2000);
                System.out.println("Reading lock 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("End read lock 3");
                rwl.readLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                rwl.writeLock().lock();
                System.out.println("Write start lock 1");
                Thread.sleep(2000);
                System.out.println("Writing lock 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("End Write lock 1");
                rwl.writeLock().unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                rwl.readLock().lock();
                System.out.println("Read start lock 4");
                Thread.sleep(2000);
                System.out.println("Reading lock 4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("End read lock 4");
                rwl.readLock().unlock();
            }
        }).start();
    }

    private static void simpleLock() {
        final Lock lock = new ReentrantLock();

        new Thread(() -> {
            System.out.println("Before lock 1");
            try {
                lock.lock();
                System.out.println("Got lock 1");
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("End lock 1");
                lock.unlock();
            }
        }).start();

//        new Thread(() -> {
//            System.out.println("Before lock 2");
//            try {
//                lock.lock();
//                System.out.println("Got lock 2");
//                Thread.sleep(7000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                System.out.println("End lock 2");
//                lock.unlock();
//            }
//        }).start();

        new Thread(() -> {
            System.out.println("Before lock 3");
            try {
                if (lock.tryLock(2, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Got lock 3");
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("End lock 3");
                        lock.unlock();
                    }
                } else System.out.println("Не очень надо");

            } catch (InterruptedException e) {

            }
        }).start();
    }

    private static void executors() throws InterruptedException, ExecutionException {
        //        ExecutorService executorService

//        Thread t = new Thread(() -> System.out.println("skfnfojdfngdfn"));
//        t.start();
//        t.join();
//        Thread.sleep(1000);
//        t.start();

        ExecutorService executorService = Executors.newFixedThreadPool(2, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("MyThread");

                return t;
            }
        });
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Hello! " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello!!!!";
            }
        });
        System.out.println(future.get());
//        Thread.sleep(2000);
        executorService.shutdown();
//        executorService.awaitTermination(10, TimeUnit.MINUTES);
    }
}
