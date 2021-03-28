package ru.geekbrains.lesson7.HomeworkAG;

public class Cat implements Runner {
    private final String name;
    private final String type;
    private final int maxHeight;
    private final int maxLength;

    public Cat(String name, int maxHeight, int maxLength) {
        this.name = name;
        this.type = "Кот";
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getType() { return type; }

    @Override
    public int getMaxLength() { return maxLength; }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }
}
