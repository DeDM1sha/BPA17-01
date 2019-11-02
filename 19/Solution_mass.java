package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {


    /*
     * Всякий раз, когда Гоша просит Лизу потусоваться, она занята домашним заданием.
     * Гоша хочет помочь ей закончить это быстрее. Можете ли вы помочь Гоше понять домашнее
     * задание Лизы, чтобы она могла погулять с ним?
     * Рассмотрим массив различных целых чисел. Можно менять местами любые два элемента массива
     * любое количество раз. Массив "красив", если сумма разностей двух соседних элементов минимальна.
     * sum(|qrr[i] - arr[i - 1]|) -> min
     * Определите минимальное количество перестановок, которые должны быть выполнены
     * для того, чтобы сделать массив "красивым".
     *
     * 1 <= n <= 10e5
     * 1 <= qrr[i] <= 2*10e9
     *
     *
     * Пример: 4
     *
*               2 5 3 1
     *
     *      (2 - 5) + (5 - 3) = -2
     *      (3 - 5) + (3 - 1) = -1
     *
     *          1 2 3 5
     *
     *      (1 - 2) + (2 - 3) = -2
     *      (2 - 3) + (3 - 5) = -3
     *
     *          1 3 5 2
     *
     *      (1 - 3) + (3 - 5) = -4
     *      (3 - 5) + (5 - 2) = 1
     *
     * Ответ: 2
     *        1 <=> 2, 2 <=> 5
     *
     * Пример: 3
     *         2 3 1
     *
     *      (2 - 3) + (3 - 1) = 1
     *
     *
     *         1 3 2
     *
     *      (1 - 3) + (3 - 2) = -1
     *
     * Ответ: 1
     *	 1 <=> 2
     *
     *  2 5 3 1
     *  1 5 3 2
     *  1 3 5 2
     */

    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {

        int Count = 0;
        int[] SortArray = new int[arr.length];

            for (int i = 0; i < arr.length; i++)
                SortArray[i] = arr[i];

        int Temp = 0;

            for (int i = 0; i < SortArray.length - 1; i++) {

                for (int j = 0; j < SortArray.length - i - 1; j++) {

                    if (SortArray[j] > SortArray[j + 1]) {

                        Temp = SortArray[j];
                        SortArray[j] = SortArray[j + 1];
                        SortArray[j + 1] = Temp;
                    }

                }

            } // сортируем массив

        boolean Flag = false;
        int Min = 0;
        int Max = 0;

            for (int i = 0; i < arr.length / 2; i++) {

                if (Flag == false) {

                    Temp = arr[i];
                    arr[i] = SortArray[i];
                    arr[arr.length - 1 - Min] = Temp;
                    Flag = true;
                    Min++;
                    Count++;

                }

                else if (Flag == true) {

                    Temp = arr[arr.length - 1 - Max];
                    arr[arr.length - 1 - Max] = SortArray[arr.length - 1 - Max];
                    arr[i] = Temp;
                    Flag = false;
                    Max++;
                    Count++;

                }

            }

            System.out.println ("Получившийся массив: ");

                for (int i = 0; i < arr.length; i++)
                    System.out.print (arr[i] + " ");

        return Count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = lilysHomework(arr);

        System.out.println ("\nКол-во перестановок: " + result);

        scanner.close();

       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/



    }
}
