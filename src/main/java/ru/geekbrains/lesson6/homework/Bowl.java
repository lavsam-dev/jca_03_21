package ru.geekbrains.lesson6.homework;

public class Bowl {
    private int food;

    public Bowl() {
        this.food = 0;
    }

    public boolean decreaseFood(int amount) {
        if (this.food - amount < 0) return false;
        this.food -= amount;
        return true;
    }

    public int getFood() {
        return this.food;
    }

    public void increaseFood(int amount) {
        this.food += amount;
    }
}
