package ru.geekbrains.lesson11;

import ru.geekbrains.lesson5.Cat;
import ru.geekbrains.lesson5.Parrot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Generics {

    public static void main(String[] args) {
        //simpleEx();
        //GenBox();

//        numbersEx();

//        double a = 0.7;
//        double b = 0.0;
//        for (int i = 0; i < 70; i++) {
//            b += 0.01;
//        }
//        System.out.println(a == b);
//        System.out.println(a);
//        System.out.println(b);

        ArrayList<String> strings = new ArrayList<>(Arrays.asList("Jan", "Feb", "Mar"));
        System.out.println(getFirstObj(strings));
        System.out.println(((String) getFirstObj1(strings)).toLowerCase());

//        Collections.copy();
    }

    static Object getFirstObj1(List list) {
        return list.get(0);
    }


    static <T> T getFirstObj(List<T> list) {
        return list.get(0);
    }

    private static void numbersEx() {
//        BoxWithNumbers<Integer> b1 = new BoxWithNumbers<>(256);
//        BoxWithNumbers<Integer> b2 = new BoxWithNumbers<>(4096);

        BoxWithNumbers<Float> bf1 = new BoxWithNumbers<>(256f);
        BoxWithNumbers<Float> bf2 = new BoxWithNumbers<>(4096f);

//        System.out.println(b1.sum(b2));
//        System.out.println(bf1.sum(bf2));
//        System.out.println(bf1.sum(b2));

        BoxWithNumbers<Integer> b1 = new BoxWithNumbers<>(10, 11, 12, 15, 0, 0);
        BoxWithNumbers<Integer> b2 = new BoxWithNumbers<>(5, 3, 20, 10, 5, 5);
        System.out.println(b1.equalsByAvg(b2));
    }

    static class BoxWithNumbers<M extends Number> {
        private List<M> numbers;

        public boolean equalsByAvg(BoxWithNumbers<?> another) {
            return Math.abs(avg() - another.avg()) < 0.00001;
        }

        public double avg() {
            double sum = 0.0;
            for (M number : numbers) {
                sum += number.doubleValue();
            }
            return  sum / numbers.size();
        }

//        public double sum(BoxWithNumbers<?> another){
//            return another. doubleValue() + another.obj.doubleValue();
//        }

        public BoxWithNumbers() {
            numbers = new ArrayList<>();
        }

        public BoxWithNumbers(M... numbers) {
            this.numbers = new ArrayList<>(Arrays.asList(numbers));
        }

        public List<M> getNumbers() {
            return numbers;
        }

        public void setNumbers(List<M> numbers) {
            this.numbers = numbers;
        }
    }

    private static void GenBox() {
        GenBox<String> b1 = new GenBox("Java");
        GenBox b11 = new GenBox("Java");

        GenBox<Integer> b2 = new GenBox(10);
        GenBox<Integer> b3 = new GenBox(15);

        GenBox<String> b4 = new GenBox<>("ssssss");

        System.out.println(b1.getObj() + b4.getObj());

        System.out.println(b2.getObj() + b3.getObj());
    }

    static class GenBox<U/*, Q, M*/> {
        private U obj;
        //private M objM;

        public GenBox() {
        }

        public GenBox(U obj) {
            this.obj = obj;
        }

        public U getObj() {
            return obj;
        }

        public void setObj(U obj) {
            this.obj = obj;
        }
    }

    private static void simpleEx() {
        SimpleBox b1 = new SimpleBox("Java");
        SimpleBox b2 = new SimpleBox(10);
        SimpleBox b3 = new SimpleBox(15);

        ArrayList list = new ArrayList();
        list.add(10);
        list.add(15);
        list.add("Java");
        list.add(new Cat("Barsik", "red", 10));
        list.add(new Parrot("Kuku", "yellow", 100));

        for (Object o: list) {
            System.out.println(o);
        }

        // много кода....
        //b3.setObj("Some String");

        ///............

        //System.out.println((Integer) b2.getObj() + (Integer) b3.getObj());

        if (b2.getObj() instanceof Integer && b3.getObj() instanceof Integer)
            System.out.println((Integer) b2.getObj() + (Integer) b3.getObj());
        // ...............
    }

    static class SimpleBox {
        private  Object obj;

        public SimpleBox(Object obj) {
            this.obj = obj;
        }

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }
    }
}
