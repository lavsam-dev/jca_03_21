package ru.geekbrains.lesson8.Homework;

/*
1.  Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2.  Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит
    символ или текст вместо числа), должно быть брошено исключение MyArrayDataException
    с детализацией, в какой именно ячейке лежат неверные данные.
3.  В методе main() вызвать полученный метод, обработать возможные исключения
    MyArraySizeException и MyArrayDataException и вывести результат расчета.
 */
public class Homework {
    public static void main(String[] args) {
        String[][] arrayLegal = new String[][] {
                {"45", "56", "3", "r127"},
                {"8694", "452", "98", "362"},
                {"985", "55", "98", "1024"},
                {"876", "12999", "99999999", "-453a"}
        };

        String[][] arrayIllegal1 = new String[][] {
                {"45", "Валли 56", "3", "Ева-127"},
                {"985", "Лиза55вета", "Марго98", "1024"},
                {"876", "12999.47", "99999999", "-453"}
        };
        String[][] arrayIllegal2 = new String[][] {
                {"45", "Валли 56", "3"},
                {"Максим", "452", "98Федор"},
                {"985", "Лиза55вета", "Марго98"},
                {"876", "12999.47", "99999999"}
        };
        sumArrayWithEx(arrayIllegal1);
        sumArrayWithEx(arrayIllegal2);
        sumArrayWithEx(arrayLegal);
    }

    private static void sumArrayWithEx(String[][] array) {
        boolean cont = true;
        do {
            int sumArray = 0;
            arraySum Sum = new arraySum(4);

            try {
                sumArray = Sum.summa(array);
                cont = false;
            } catch (MyArraySizeException ase) {
                System.out.println("Ошибка размерности массива, надо 4, размер: " + ase.getNumber());
                cont = false;
            } catch (MyArrayDataException ade) {
                sumArray = ade.getSum();
                System.out.printf("Ошибка в элементе массива, индексы: %d %d, элемент: %s\n", ade.getIndexI(), ade.getIndexJ(), ade.getElementArr());
                array[ade.getIndexI()][ade.getIndexJ()] = "0";
            }
            if (cont) System.out.println("Сумма элементов массива: " + sumArray);
        }
        while (cont);
    }
}
