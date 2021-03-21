package ru.geekbrains.lesson6.homework;

public class Homework {
    public static void main(String[] args) {
        String[] nameCats = { "Барсик", "Васька", "Кузя", "Филя", "Мурзик", "Пушок",
                "Бегемот", "Пират", "Леопольд", "Каспер"};
        int amountCats = (int)(Math.random() * 5) + 4;
        Cat[] cats = new Cat[amountCats];
        Bowl commonBowl = new Bowl();
        int commonAppetite = 0;

        for (int i = 0; i < amountCats; i++) {
            int appetite = (int)(Math.random() * 10) + 10;
            cats[i] = new Cat(nameCats[i], appetite);
            commonBowl.increaseFood(appetite + 5);
            commonAppetite += appetite;
        }

        while (commonBowl.getFood() > 0) {
            for (Cat cat : cats) {
                cat.eat(commonBowl);
            }
            commonBowl.increaseFood((int) (Math.random() * (commonAppetite / 2)));
            System.out.printf("В миске осталось %d еды", commonBowl.getFood());
        }
    }
}
