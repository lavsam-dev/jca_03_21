package ru.geekbrains.lesson8;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Project jca_02_21
 *
 * @Author Alexander Grigorev
 * Created 25.03.2021
 * v1.0
 */
public class Exceptions {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);
             Socket socket = new Socket("localhost", 403)) {
            System.out.println(scanner.next());
        } catch (IOException e) {

        }
    }

    private static void example() {
        Scanner scanner = new Scanner(System.in);
        float a, b;

        do {

            System.out.println("Введите 2 числа через пробел>>>");
            try {
                a = scanner.nextFloat();
                b = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                continue;
            }
        } while (true);
        scanner.close();
//        InputMismatchException e;

        System.out.println(a / b);
        System.out.println("Before");
        try {
            System.out.println("From try");
            throwException(1);
            System.out.println("Before some else");
            throwSomeElse();
        } catch (MyCustomException exception) {
            System.out.println("Caught!");
            exception.printStackTrace();
        } catch (SomeElseException e) {
            System.out.println("Caught some else exception!");
        } finally {
            System.out.println("FROM FINALLY!");
        }

        try {
            throw new StackOverflowError();
        } catch (StackOverflowError e) {

        }

//        try {
//            throw new IndexOutOfBoundsException();
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Caught IOOBE");
//        }


//        try {
//            System.out.println();
//        } catch (OutOfMemoryError error) {
//            error.printStackTrace();
//        }

        System.out.println("After exception");
    }

    static void doSomethingImportant() throws MyCustomException {
        //a lot of code
        throwException(-1);
        //a lot of code
    }

    static void throwException(int a) throws MyCustomException {
        if (a < 0) throw new MyCustomException("Custom Exception");
//        Exception e = new MyCustomException("odfbojdbgno");
//        throw  e;
    }

    static void throwSomeElse() {
        throw new SomeElseException();
    }

    static class MyCustomException extends Exception {
        public MyCustomException() {
        }

        public MyCustomException(String message) {
            super(message);
        }
    }

    static class SomeElseException extends RuntimeException {
    }
}
