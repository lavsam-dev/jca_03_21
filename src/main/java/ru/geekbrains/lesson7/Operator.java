package ru.geekbrains.lesson7;

/**
 * Project jca_02_21
 *
 * @Author Alexander Grigorev
 * Created 22.03.2021
 * v1.0
 */
public enum Operator {
    SUM {
        public int operation(int x, int y) {return x + y;}
    },
    MUL {
        public int operation(int x, int y) {return x * y;}
    };

    public abstract int operation(int x, int y);
}
