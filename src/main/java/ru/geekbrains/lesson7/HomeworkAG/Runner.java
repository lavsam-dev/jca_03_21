package ru.geekbrains.lesson7.HomeworkAG;

public interface Runner {
    String getName();

    String getType();

    int getMaxLength();

    int getMaxHeight();

    default boolean run(int length) {
        if (length <= getMaxLength()) {
            System.out.printf("%s %s пробежал по трассе %dм\r\n", getType(), getName(), length);
            return true;
        } else {
            System.out.printf("%s %s не может пробежать %dм, он может пробежать только %dм и останавливается\r\n", getType(), getName(), length, getMaxLength());
            return false;
        }
    }

    default boolean jump(int height) {
        if (height <= getMaxHeight()) {
            System.out.printf("%s %s прыгнул через барьер %dсм\r\n", getType(), getName(), height);
            return true;
        } else {
            System.out.printf("%s %s не может перепрыгнуть барьер %dсм, он может прыгнуть только на %d и останавливается\r\n", getType(), getName(), height, getMaxHeight());
            return false;
        }
    }

    default boolean overcome(Obtacle obtacle) {

        switch (obtacle.getTypeObtacle()) {
            case typeWall: return jump(obtacle.getHeight());
            case typeTrack: return run(obtacle.getLength());
        }
        return jump(obtacle.getHeight());
    }
}
