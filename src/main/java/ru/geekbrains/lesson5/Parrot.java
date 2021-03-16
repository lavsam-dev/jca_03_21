package ru.geekbrains.lesson5;

/**
 * Project jca_02_21
 *
 * Author Alexander Grigorev
 * Created 15.03.2021
 * v1.0
 */
public class Parrot extends Bird {
    public Parrot(String name, String color, int age) {
        super(name, color, age);
        this.type = "Parrot";
    }

    public void speak() {
        System.out.printf("lzslfnvjdfjbnkdjfb\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parrot)) return false;
        Parrot another = (Parrot) o;

        if (this.color.equals(another.color)
                && this.name.equals(another.name)
                && this.age == another.age) {
            return true;
        }
        return false;
    }
}
