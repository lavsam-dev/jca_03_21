package ru.geekbrains.lesson5;

/**
 * Project jca_02_21
 *
 * Author Alexander Grigorev
 * Created 15.03.2021
 * v1.0
 */
public class Snake extends Animal {

    public Snake(String name, String color, int age) {
        super(name, color, age);
        this.type = "Snake";
    }

    @Override
    public void voice() {
        System.out.printf("Snake %s sssshh Bandarlogs!\n", this.name);
    }

    @Override
    public void run() {
        System.out.printf("Snake %s is crawling\n", this.name);
    }

    public void animalRun() {
        super.run();
    }

    public boolean doSomething(int s) {
        System.out.printf("Snake %s is crawling", this.name);
        return true;
    }

    public int doSomething() {
        System.out.printf("Snake %s is crawling", this.name);
        return 10;
    }
}
