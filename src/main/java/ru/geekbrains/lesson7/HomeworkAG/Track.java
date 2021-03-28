package ru.geekbrains.lesson7.HomeworkAG;

public class Track implements Obtacle {
    private final int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public int getLength() { return length; }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public typeObtacle getTypeObtacle() {
        return typeObtacle.typeTrack;
    }
}
