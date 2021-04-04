package ru.geekbrains.lesson10;

import java.util.Objects;

public class Box implements Comparable<Box> {
    int width;
    int height;
    int flag;


    public Box() {
    }

    public Box(int width, int height) {
        this.width = width;
        this.height = height;

    }

    public Box(int width, int height, int flag) {
        this.width = width;
        this.height = height;
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box box = (Box) o;
        return width == box.width &&
                height == box.height;
    }

    @Override
    public int hashCode() {
//            return 1;
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", height=" + height +
                ", flag=" + flag +
                '}';
    }

    @Override
    public int compareTo(Box o) {
        return this.width + this.height - o.width - o.height;
    }
}
