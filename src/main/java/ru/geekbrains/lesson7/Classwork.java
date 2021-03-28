package ru.geekbrains.lesson7;

/**
 * Project jca_02_21
 *
 * @Author Alexander Grigorev
 * Created 22.03.2021
 * v1.0
 */
public class Classwork {


    //ENUM
    //Inner
    //Interface

    public static void main(String[] args) {

        Flyable han = new Flyable() {
            @Override
            public void fly(int length) {
                System.out.println("Anonymous han flying");
            }

            @Override
            public void land() {
                System.out.println("Anonymous han landing");

            }
        };

        han.fly(10);
        han.land();

        Flyable butterfly = new Flyable() {
            @Override
            public void fly(int length) {
                System.out.println("Anonymous butterfly flying");
            }

            @Override
            public void land() {
                System.out.println("Anonymous butterfly landing");

            }
        };

        butterfly.fly(10);
        butterfly.land();

        Walking walker = () -> System.out.println("Hello!");


        walker.walk();

        workWithLambda((i, q) -> {
            System.out.println("Lambda " + i + " " + q);
            System.out.println("Else");
        });

        workWithLambda((a, b) -> System.out.println("Something"));

        workWithLambda(new FuncInterface() {
            @Override
            public void doSomething(int a, String b) {
                System.out.println("fhbhdfbfvhd");
            }
        });


    }

    private static void workWithLambda(FuncInterface lambda) {
        lambda.doSomething(500, "LambdaLambda");
    }

    private static void interfacesExample() {
        Flyable duck = new Duck();
        Flyable plane = new Plane();

        Flyable[] flyables = new Flyable[2];
        flyables[0] = duck;
        flyables[1] = plane;

        for (Flyable flyable : flyables) {
            flyable.fly(100);
            flyable.land();
        }

        ((Duck) duck).walk();

        System.out.println(Flyable.s);
//        Flyable.s = "";
        duck.doDefault();
        plane.doDefault();
        Flyable.doStatic();
    }

    static class Duck implements Flyable, Walking, Cloneable {

        @Override
        public void fly(int length) {
            System.out.println("Duck flying for " + length);
        }

        @Override
        public void land() {
            System.out.println("Duck landing");
        }

        @Override
        public void walk() {
            System.out.println("Duck walking!");
        }
    }

    static class Plane implements Flyable {

        @Override
        public void fly(int length) {
            System.out.println("Plane flying for " + length);
        }

        @Override
        public void land() {
            System.out.println("Plane landing");
        }

        @Override
        public void doDefault() {
            System.out.println("Plane s default");
        }
    }

    private static void localExample() {
        class Dog {  //local
            String type;
            int age;

            public Dog(String type, int age) {
                this.type = type;
                this.age = age;
            }

            @Override
            public String toString() {
                return "Dog{" +
                        "type='" + type + '\'' +
                        ", age=" + age +
                        '}';
            }
        }

        Dog d = new Dog("Dog", 10);
        Dog d1 = new Dog("Dog", 3);

        System.out.println(d);
        System.out.println(d1);
    }

    private static void innerExample() {
        Car c = new Car("Lada");
//        System.out.println(c.getEngine());
        System.out.println(c);
        Car.Engine engine = c.getEngine();
        Car.Engine newEngine = new Car("Taz").new Engine(10, "");
        engine.doSomething();
        System.out.println(c);
        Car.Engine e = c.new Engine(100500, "!!!");
        Car.Engine e1 = c.new Engine(100500, "!!!");

        Car.Cat cat = new Car.Cat("Barsik", "White");


    }

    private static void enumsExample() {
        WeekDay day = WeekDay.SUNDAY;
        System.out.println(day);
        day = WeekDay.MONDAY;
        System.out.println(day.ordinal());

        System.out.println(day.ordinal() + " " + day.getDayNumber() + " " + day.getRussianName());

        Operator op = Operator.SUM;
        System.out.println(op.operation(10, 15));
        op = Operator.MUL;
        System.out.println(op.operation(12, 24));
    }

    enum ErrorCodes {
        FORBIDDEN(403),
        OK(200);

        public int code;

        ErrorCodes(int code) {
            this.code = code;
        }
    }

    interface SomeInterface {

    }

}
