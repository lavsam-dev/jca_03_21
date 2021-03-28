package ru.geekbrains.lesson7.Classrework;

public enum Weekday {
    Wednesday(3, "Среда"),
    Tuesday(2, "Вторник"),
    Saturday(6, "Суббота"),
    Thursday(4, "Четверг"),
    Friday(5, "Пятница"),
    Monday(1, "Понедельник"),
    Sunday(7, "Воскресенье");

    private int dayNumber;
    private String russianName;

    Weekday(int dayNumber, String russianName) {
        this.dayNumber = dayNumber;
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }

    public int getDayNumber() {
        return dayNumber;
    }
}
