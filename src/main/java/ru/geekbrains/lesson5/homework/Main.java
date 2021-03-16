package ru.geekbrains.lesson5.homework;

public class Main {
    public static void main(String[] args) {
        System.out.println("Кошки и собаки");
        Cat c1 = new Cat("Филя");
        Dog d1 = new Dog("Джек");
        c1.Run(10);
        c1.Sweem(5);
        d1.Sweem(30);
        d1.Run(100);
        c1.Run(300);
        Dog d2 = new Dog("Барбос");
        d2.Run(50);
        d2.Sweem(40);
        System.out.printf("Всего животных: %d\n", Animal.getqAnimal());
        System.out.printf("Котов: %d\n", Cat.getqCat());
        System.out.printf("Собак: %d\n", Dog.getqDog());
    }
}
