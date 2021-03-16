package ru.geekbrains.lesson4.homework;

public class Main {
    public static void main(String[] args) {
        String firm = "'Java Forever Inc'";
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("James Arthur Gosling (Dr. Java)",
            "Founder and lead designer behind the Java", "JamesGosling@gmail.com",
                "810 1 206-922-0880", 1833000f, 65
        );
        employees[1] = new Employee("Lawrence Edward Page",
                "CEO Alphabet Inc", "LarryPage@gmail.com",
                "(650) 253-0001", 2100000f, 47
        );
        employees[2] = new Employee("Sergey Mikhaylovich Brin",
                "President of Alphabet Inc", "SergeyBrin@gmail.com",
                "(650) 253-0001", 2100000f, 47
        );
        employees[3] = new Employee("Andrew E. Rubin (Andy Rubin)",
                "former CEO of Android Inc", "Android@gmail.com",
                "+1 650 427 0000", 900000f, 57
        );
        employees[4] = new Employee("Александр Григорьев", "Разработчик в АО «Магнит»",
                "alexgrigoriev@mail.ru", "8 800 200-90-02", 3000, 31
        );

        System.out.println("Сотрудники " + firm + " старше 40 лет");
        for (int i = 0; i < 5 && employees[i] != null; i++) {
            if (employees[i].getAge() > 40) employees[i].printToConsole();
        }
        System.out.println("\nСотрудники " + firm + " не старше 40 лет");
        for (int i = 0; i < 5 && employees[i] != null; i++) {
            if (employees[i].getAge() <= 40) employees[i].printToConsole();
        }
    }
}
