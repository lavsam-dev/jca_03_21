package ru.geekbrains.lesson6;

/**
 * Project jca_02_21
 *
 * @Author Alexander Grigorev
 * Created 18.03.2021
 * v1.0
 */
public class Plate extends AbstractBowl {

    public void decreaseFood(int amount) {
        super.decreaseFood(amount);
        System.out.println("Food from plate decreased, now there is " + super.getFood());
    }

}
