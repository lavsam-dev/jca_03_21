package ru.geekbrains.lesson6;

/**
 * Project jca_02_21
 *
 * @Author Alexander Grigorev
 * Created 18.03.2021
 * v1.0
 */
public class Cat /*extends AbstractBowl */{
    private String name;
    private int appetite;
    private int health;
    private int damage;

    public Cat(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void hit(Cat another) {
        System.out.printf("Cat %s had hit cat %s\n", this.name, another.getName());
        another.getHit(this.damage);
    }

    public void getHit(int damage) {
        this.health -= damage;
        System.out.println("Auch, health now is " + this.health);
        if (this.health <= 0) System.out.printf("Cat %s died\n", this.name);
    }

    public void eat(AbstractBowl bowl) {
        bowl.decreaseFood(this.appetite);
        System.out.printf("Cat %s had ate from bowl for %d food!\n", this.name, this.appetite);
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }


    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
}
