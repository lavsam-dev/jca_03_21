package ru.geekbrains.lesson7.Homework;

public class Wall implements Overcoming {
    private final String type = "Wall";
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    @Override
    public void overcome() {

    }
}
