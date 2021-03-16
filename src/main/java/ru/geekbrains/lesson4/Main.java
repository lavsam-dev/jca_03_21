package ru.geekbrains.lesson4;

public class Main {
    public static void main(String[] args){
        String name = "Barsik";
        name = "Vasya";

        Cat c = new Cat("Murzik", "White", 3);

        Cat c1 = new Cat();
        c1.setName("Barsik");
        //c1.name = "Barsik";
        //c1.color = "Black";
        //c1.age = 5;

        Cat c2 = new Cat();

        //System.out.printf("Cat %s it's color %s, age is %d\n", c.name, c.color, c.age);
        //System.out.printf("Cat %s it's color %s, age is %d\n", c1.name, c1.color, c1.age);
        //System.out.printf("Cat %s it's color %s, age is %d\n", c2.name, c2.color, c2.age);
        System.out.println(c.getName());

        c.jump();
        c.jump(1.53f);
        Table t = new Table();
        t.name = "Table";
        c.jump(t.name);
        c1.jump();
        c.voice();
        c1.voice();

    }

}
