package ru.geekbrains.lesson7;

/**
 * Project jca_02_21
 *
 * @Author Alexander Grigorev
 * Created 22.03.2021
 * v1.0
 */
public enum WeekDay {
    WEDNESDAY(3, "Среда"),
    TUESDAY(2, "Вторник"),
    SATURDAY(6, "Суббота"),
    THURSDAY(4, "Четверг"),
    FRIDAY(5, "Пятница"),
    MONDAY(1, "Понедельник"),
    SUNDAY(7, "Воскресенье");

    private int dayNumber;
    private String russianName;

    WeekDay(int dayNumber, String russianName) {
        this.dayNumber = dayNumber;
        this.russianName = russianName;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public String getRussianName() {
        return russianName;
    }
}
