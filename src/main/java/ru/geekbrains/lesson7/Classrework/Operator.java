package ru.geekbrains.lesson7.Classrework;

public enum Operator {
    SUM {
        public int operation(int x, int y) {return x + y;}
    },
    MUL {
        public int operation(int x, int y) {return x * y;}
    };

    public abstract int operation(int x, int y);
}
