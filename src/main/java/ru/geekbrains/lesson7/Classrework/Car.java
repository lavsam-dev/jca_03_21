package ru.geekbrains.lesson7.Classrework;

public class Car {  //Outer
    private static String s = "HHHHH";
    private String name;
    private Engine engine;
    private Engine engine2;

    public Car(String name) {
        this.name = name;
        this.engine = new Engine(500, "TDH");
        this.engine2 = new Engine(100, "Reserve");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doSomething() {

    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", engine=" + engine +
                '}';
    }

    class Engine {  //Inner (non static)
        private int power;
        private String title;

        public Engine(int power, String title) {
            this.power = power;
            this.title = title;
        }

        public void doSomething() {
            name = "Volga";
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "power=" + power +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    static class Cat { //static inner (nested)
        String name;
        String color;

        public void doSomething() {
            Car c = new Car("Lada");
            System.out.println(Car.s);
        }

        public Cat(String name, String color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
//
//class SomeClass {
//
//}