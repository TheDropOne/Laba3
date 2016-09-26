package by.thedrop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kuryakov on 17-Sep-16.
 */

public class Runner {

    private static int first, second, count = 0;
    private static int countPascal = 0;

    public static void main(String[] args) {
        initializeVariables();
        fibonachiRow(first, second, count);
        initializePascalVariable();
        calculatePascalTriangle(countPascal);
    }

    private static void initializeVariables() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Pattern pattern = Pattern.compile("\\d+");
            int[] array = new int[3];
            int iterator = 0;
            while (iterator != 3) {
                System.out.println("Waiting for input");
                String s = br.readLine();
                Matcher matcher = pattern.matcher(s);
                while (matcher.find() && iterator != 3) {
                    array[iterator] = Integer.parseInt(matcher.group());
                    iterator++;
                }
            }
            first = array[0];
            second = array[1];
            count = array[2];
        } catch (Exception ex) {
            System.exit(100500);
        }
    }

    private static void initializePascalVariable() {
        while (countPascal == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please, input count of numbers in Pascal Triangle");
            if (scanner.hasNextInt()) {
                countPascal = scanner.nextInt();
            }
        }
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
