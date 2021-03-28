package ru.geekbrains.lesson7.Classrework;

public class Classrework {
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

        Walking walker = () -> System.out.println("Hello!");
        walker.walk();

        workWithLambda((b, c) -> {
            System.out.println("Lambda " + b + " " + c);
            System.out.println("+++++++");
        });
    }

    private static void  workWithLambda(FuncInterface lambda) {
        lambda.doSomething(500, "Lambdadada");
    }

    private static void interfaceExample() {
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
        //System.out.println(Flyable.s);
        //Flyable.s = "";
        duck.doDefolt();
        plane.doDefolt();
        Flyable.doStatic();
    }

    static class Duck implements Flyable, Walking {

        @Override
        public void fly(int length) {
            System.out.println("Duck flying for " + length);
        }

        @Override
        public void land() {
            System.out.println("Duck lending");
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
            System.out.println("Plane lending");
        }

        @Override
        public void doDefolt() {
            System.out.println("Plane s default");
        }
    }

    private static void localExample() {
        class Dog { // local
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
        Dog d2 = new Dog("Dog", 3);

        System.out.println(d);
        System.out.println(d2);
    }

    private static void innerExample() {
        Car c = new Car("Lada");
        //System.out.println(c.getEngine());
        System.out.println(c);
        Car.Engine engine = c.getEngine();
        Car.Engine newEngine = new Car("TAZ").new Engine(300, "TV");
//        Car.Engine engine = new Car.Engine();
        engine.doSomething();
        System.out.println(c);
        Car.Engine e = c.new Engine(100500, "!!!");

        Car.Cat cat = new Car.Cat("Barsik", "White");
    }

    private static void enumsExample() {
        Weekday day = Weekday.Sunday;
        System.out.println(day);
        day = Weekday.Monday;
        System.out.println(day.ordinal());

        System.out.println(day.ordinal() + " " + day.getDayNumber() + " " + day.getRussianName());

        Operator op = Operator.SUM;
        System.out.println(op.operation(3, 5));
        op = Operator.MUL;
        System.out.println(op.operation(8, 5));

        ErrorCodes er = ErrorCodes.FORBIDDEN;
        System.out.println(er);
    }

    enum ErrorCodes {
        FORBIDDEN(403),
        OK(200);

        public int code;

        ErrorCodes(int code) {
            this.code = code;
        }
    }
}
