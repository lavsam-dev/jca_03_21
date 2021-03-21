package ru.geekbrains.lesson6;

/**
 * Project jca_02_21
 *
 * @Author Alexander Grigorev
 * Created 18.03.2021
 * v1.0
 */
public abstract class AbstractBowl {
    private int food;

    public void putFood(int amount) {
        this.food += amount;
    }

    public void decreaseFood(int amount) {
        this.food -= amount;
    }

    public int getFood() {
        return this.food;
    }
}
