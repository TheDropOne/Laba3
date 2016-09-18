package by.thedrop;

import java.util.Scanner;

/**
 * Created by Kuryakov on 17-Sep-16.
 */

public class MainClass {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        System.out.println("Please, input three numbers");
        int x0 = 0, x1 = 0, n = 0;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            x0 = scanner.nextInt();
        }
        if (scanner.hasNextInt()) {
            x1 = scanner.nextInt();
        }
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        fibonachiRow(x0, x1, n);
    }

    private static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, input count of numbers in Pascal Triangle");
        int count = 0;
        if (scanner.hasNextInt()) {
            count = scanner.nextInt();
        }
        calculatePascalTriangle(count);
    }

    private static void fibonachiRow(int x0, int x1, int n) {
        if (n <= 0) {
            System.out.println("Count <= 0");
            return;
        }
        int[] array = new int[n];
        int summ;
        System.out.print(x0 + " " + x1 + " ");
        for (int i = 0; i < n; i++) {
            summ = x0 + x1;
            x0 = x1;
            x1 = summ;
            array[i] = summ;
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void calculatePascalTriangle(int count) {
        if (count <= 0) {
            System.out.println("Count <= 0");
            return;
        }
        String[] arrayOfStrings = new String[count];
        for (int i = 0; i < count; i++) {
            int firstRow = 1;
            arrayOfStrings[i] = firstRow + "";
            for (int j = 0; j < i; j++) {
                firstRow *= (i - j);
                firstRow /= (j + 1);
                arrayOfStrings[i] += (" " + firstRow);
            }
        }
        for (String a : arrayOfStrings) {
            System.out.println(a);
        }
    }
}
