package ru.geekbrains.lesson13.Homework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Racing {
    public static final int CARS_COUNT = 4;
    public static final CyclicBarrier cyclicBarrierStart = new CyclicBarrier(CARS_COUNT + 1);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), 0);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            while (cyclicBarrierStart.getNumberWaiting() != CARS_COUNT) {
                Thread.sleep(200);
            }

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cyclicBarrierStart.await();

            while (cyclicBarrierStart.getNumberWaiting() != CARS_COUNT) {
                Thread.sleep(200);
            }
            cyclicBarrierStart.await();

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
