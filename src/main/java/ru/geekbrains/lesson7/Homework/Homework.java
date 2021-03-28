package ru.geekbrains.lesson7.Homework;

public class Homework {
    public static void main(String[] args) {
        Human human = new Human("Jack", 50, 100);
        human.jump(200);
        human.run(100);

        Running robot = new Robot("Бишоп", 200, 200);
        robot.run(100);
        ((Jumping)robot).jump(200);

    }
}
