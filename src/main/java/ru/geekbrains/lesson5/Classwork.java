package ru.geekbrains.lesson5;

public class Classwork {
    public static void main(String[] args) {
//        Animal a = new Animal();
//
//        byte byteVal = 100;
//        System.out.println(byteVal == 100);
//        int intVal = 512;
//        byte b2 = (byte) intVal;
//
//        System.out.println(b2);

        Animal[] zoo = {
                new Cat("Barsik", "Red", 3),
                new Bird("Chizhik", "Blue", 1),
                new Dog("Tuzik", "Black", 2),
                new Horse("Plotva", "Brown", 5),
                new Snake("Kaa", "Green", 100),
                new Parrot("Popka", "Yellow", 5)
        };

        for (int i = 0; i < zoo.length; i++) {
            zoo[i].run();
            zoo[i].voice();
            if (zoo[i] instanceof Bird) {
                Bird b2 = (Bird) zoo[i];
                b2.fly();
            }
            if (zoo[i] instanceof Parrot) {
                Parrot p2 = (Parrot) zoo[i];
                p2.speak();
            }
            System.out.println(zoo[i]);
        }

        Parrot p1 = new Parrot("Kesha", "Red", 5);
        Parrot p2 = p1;
        Parrot p3 = new Parrot("Kesha", "Red", 5);
        System.out.println(p1.equals(p2));

        System.out.println(p1.equals(p3));
//        c.voice();
//
//        b.voice();
//        b.fly();
//
//        d.voice();
//
//        h.voice();
//        s.voice();
//
//
//        p.voice();
//        p.fly();
//        p.speak();
    }
}
