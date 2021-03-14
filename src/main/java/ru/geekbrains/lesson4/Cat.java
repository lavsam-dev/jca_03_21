package ru.geekbrains.lesson4;

public class Cat {
    private String name;
    private String color;
    private int age;

    public Cat(String name, String color, int age) {
        this(color);
        this.name = name;
        this.age = age;
    }

    public Cat(String color) {
        this.color = color;
    }

    public Cat() {

    }

    public void voice() {
        System.out.printf("Cat %s meaw!\n", name);
    }

    public void jump() {
        if (age <= 4) {
            System.out.printf("Cat %s jumped!\n", name);
        } else System.out.printf("Cat %s lazily rest...\n", name );
    }
    public  void jump(float length) {
        System.out.printf("Cat %s jumped for %f for ahead\n", name, length);
    }
    public void jump(String obj) {
        System.out.printf("Cat %s jumped on the %s\n", name, obj);
    }
    public String getName() {
        return this.name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
