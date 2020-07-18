package ru.task2;

import java.sql.SQLOutput;

public class Main {

    public static void doSpaces(int numberOfTask) {
        System.out.println();
        System.out.println("==========================");
        System.out.println(numberOfTask + " задание ");
    }
    public static void main(String[] args) {

        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

        System.out.println("1 задание");
        int [] array = new int[]{0, 1, 1, 0, 1, 1, 0, 0};
        System.out.println("Изначальный вид нашего массива");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        for(int i = 0; i < array.length; i++) {
            if(array[i] == 1) {
                array[i] = 0;
            }
            else {
                array[i] = 1;
            }
        }
        System.out.println();
        System.out.println("Измененный вид массива");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // 2. Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

        doSpaces(2);
        int[] array2 = new int[8];
        int cnt = 0;
        for(int i = 0; i <= 21; i += 3) {
            array2[cnt] = i;
            System.out.print(array2[cnt] + " ");
            cnt++;
        }

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2;

        doSpaces(3);
        int[] array3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Наш изначальный массив");
        for(int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + " ");
        }
        System.out.println();
        System.out.println("Наш измененный массив");
        for(int i = 0; i < array3.length; i++) {
            if(array3[i] < 6) {
                array3[i] *= 2;
            }
            System.out.print(array3[i] + " ");
        }

        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        doSpaces(4);
        int[][] twoDimensionalArray = new int[5][5];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(i == j) {
                    twoDimensionalArray[i][j] = 1;
                }
                System.out.print(twoDimensionalArray[i][j] + " ");
            }
            if(i != 4) {
                System.out.println();
            }
        }

        // 5. ** Задать одномерный массив и найти в нем
        // минимальный и максимальный элементы (без помощи интернета);

        doSpaces(5);
        int[] array5 = new int[] {2, 5, 12, 423, 1, -24, 128, 28, 17};
        for(int i = 0; i < array5.length; i++) {
            System.out.print(array5[i] + " ");
        }
        System.out.println();
        int min = array5[0];
        int max = array5[0];
        for(int i = 0; i < array5.length; i++) {
            if(array5[i] > max) {
                max = array5[i];
            }
            if(array5[i] < min) {
                min = array5[i];
            }
        }
        System.out.println("Минимальный элемент массива = " + min);
        System.out.print("Максимальный элемент массива = " + max);

        doSpaces(6);

        int[] array6FirstTest = new int[] {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(array6FirstTest));

        int[] array6SecondTest = new int[] {1, 1, 1, 2, 1};
        System.out.println(checkBalance(array6SecondTest));

        int[] array6ThirdTest = new int[] {2, 5, 6, 12, 10, 124, 28};
        System.out.print(checkBalance(array6ThirdTest));

        doSpaces(7);

        int[] array7FirstTest = new int[] {1, 2, 3, 4, 5, 6};
        int n1 = 2;
        moveElementsOfArray(array7FirstTest, n1);

        int[] array7SecondTest = new int[] {1, 3, 5, 7, 9, 11};
        int n2 = 0;
        moveElementsOfArray(array7SecondTest, n2);

        int[] array7ThirdTest = new int[] {1, 4, 7, 10, 13, 16};
        int n3 = -3;
        moveElementsOfArray(array7ThirdTest, n3);
    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    // если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance
    // ([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.

    public static boolean checkBalance(int[] array) {
        int sumOfFirstPart = 0;
        System.out.println("Наш массив");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < array.length / 2; i++) {
            sumOfFirstPart += array[i];
        }
        int sumOfSecondPart = 0;
        for(int i = array.length / 2; i < array.length; i++) {
            sumOfSecondPart += array[i];
        }
        int cnt = array.length / 2;
        for(int i = 0; i < array.length; i++) {
            if(sumOfFirstPart > sumOfSecondPart) {
                sumOfFirstPart -= array[cnt];
                sumOfSecondPart += array[cnt];
                cnt--;
                if(sumOfFirstPart < sumOfSecondPart) {
                    return false;
                }
                else if(sumOfFirstPart == sumOfSecondPart) {
                    System.out.print("Если разделить массив после " + cnt + " элемента, ");
                    System.out.println("то получится ");
                    return true;
                }
            }
            else if(sumOfFirstPart < sumOfSecondPart) {
                sumOfFirstPart += array[cnt];
                sumOfSecondPart -= array[cnt];
                cnt++;
                if(sumOfFirstPart > sumOfSecondPart) {
                    return false;
                }
                else if(sumOfFirstPart == sumOfSecondPart) {
                    System.out.print("Если разделить массив после " + cnt + " элемента, ");
                    System.out.println("то получится ");
                    return true;
                }
            }
            else {
                System.out.print("Если разделить массив после " + cnt + " элемента, ");
                System.out.println("то получится ");
                return true;
            }
        }
        return true;
    }

    // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.

    public static void moveElementsOfArray(int[] array, int n) {
        System.out.println("Наш массив");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Смещение = " + n);
        for(int i = 0; i < array.length + n; i++) {
            for(int j = 0; j < array.length - 1; j ++) {
                int cnt = array[j + 1];
                array[j + 1] = array[j];
                array[j] = cnt;
            }
        }
        System.out.println("Наш массив после смещения");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
