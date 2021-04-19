package ru.geekbrains.lesson14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;


//    @BeforeAll
//    static void doSomething() {
//        System.out.println("Before all");
//    }
//
//    @AfterAll
//    static void doSomethingAfter() {
//        System.out.println("After all");
//    }

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

//    @AfterEach
//    void close() {
//        System.out.println("Closing");
//    }
//    @CsvSource({
//            "10,20,30",
//            "5,20,15",
//            "3,33,35",
//            "20,20,40",
//            "10,20,31",
//    })
//    @ValueSource(ints = {1,2,3,4,5});
    @CsvFileSource(files = {"tests/add_test.csv"})
    @ParameterizedTest
    @MethodSource("generateAddData")
    @Disabled
//    @Timeout(2)
    void massAddTest(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.add(a, b));
//        Assertions.assertEquals(55, calculator.add(22, 33));
//        Assertions.assertEquals(57, calculator.add(24, 33));
//        Assertions.assertEquals(49, calculator.add(22, 27));
//        Assertions.assertEquals(11, calculator.add(6, 5));
//        Assertions.assertEquals(55, calculator.add(22, 33));
//        Assertions.assertEquals(55, calculator.add(22, 33));
//        Assertions.assertEquals(55, calculator.add(22, 33));

    }

    private static Stream<Arguments> generateAddData() {
        List<Arguments> list = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            int a = (int)(Math.random() * 100_000);
            int b = (int)(Math.random() * 100_000);
            int result = a + b;
            list.add(Arguments.arguments(a,b,result));
        }
        return list.stream();
    }

    @Test
    @Timeout(2)
    void veryLongTest() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void addTest() {
//        int a = 22;
//        int b = 33;
//        int result = 55;
//        Calculator calculator = new Calculator();
        Assertions.assertEquals(55, calculator.add(22, 33));
    }

    @Test
    void subTest() {
//        Calculator calculator = new Calculator();
        Assertions.assertEquals(11, calculator.sub(33, 22));
    }

    @Test
    void mulTest() {
//        Calculator calculator = new Calculator();
        Assertions.assertEquals(10, calculator.mul(5, 2));
    }

    @Test
    void divTest() {
//        Calculator calculator = new Calculator();
        Assertions.assertEquals(10, calculator.div(100, 10));
    }

    @Test
    void divByZeroTest() {
        Assertions.assertThrows(ArithmeticException.class, ()->calculator.div(2,0));
    }
}