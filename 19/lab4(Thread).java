package com.company;

import java.io.*;
import java.util.*;

class homeWork {

    private int Count_1; // кол-во перестановок по возрастанию
    private int Count_2; // кол-во перестановок по убыванию
    private int Result; // результат

    public void setCount_1 (int Num) {

        this.Count_1 = Num;

} // сеттер для Count_1

    public int getCount_1 () {

        return this.Count_1;

    } // геттер для Count_1

    public void setCount_2 (int Num) {

        this.Count_2 = Num;

    } // сеттер для Count_2

    public int getCount_2 () {

        return this.Count_2;

    } // геттер для Count_2

    public void setResult (int Num) {

        this.Result = Num;

    } // сеттер для Result

    public int getResult () {

        return this.Result;

    } // геттер для Result

    public int lilysHomework (int[] arr) {

        int[] Array_1 = new int [arr.length];
        int[] Array_2 = new int [arr.length];

        for (int i = 0; i < arr.length; i++) {

            Array_1[i] = arr[i];
            Array_2[i] = arr[i];

        }

        for (int i = 1; i < Array_1.length; i++) {

            if (Array_1[i] < Array_1[i - 1])
                Count_1++;

            for (int j = i; j > 0 && Array_1[j-1] > Array_1[j];j--) {

                int tmp=Array_1[j-1];
                Array_1[j-1]=Array_1[j];
                Array_1[j]=tmp;

            }

        } // сортировка по возрастанию

        for (int i = 1; i < Array_2.length; i++) {

            if (Array_2[i] > Array_2[i - 1])
                Count_2++;

            for (int j = i; j > 0 && Array_2[j-1] < Array_2[j];j--) {

                int tmp=Array_2[j-1];
                Array_2[j-1]=Array_2[j];
                Array_2[j]=tmp;

            }

        } // сортировка по убыванию

        return this.Count_1 >= this.Count_2 ? this.Count_2 : this.Count_1;

    }

};

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
     *      |(2 - 5)| + |(5 - 3)| + |(3 - 1)| = 7
     *
     *          1 2 3 5
     *
     *      |(1 - 2)| + |(2 - 3)| + |(3 - 5)| = 4
     *
     * Ответ: 2
     *        1 <=> 2, 2 <=> 5
     *
     * Пример: 3
     *         2 3 1
     *
     *      |(2 - 3)| + |(3 - 1)| = 1 + 2 = 3
     *
     *         1 3 2
     *
     *      |(1 - 3)| + |(3 - 2)| = 2 + 1 = 3
     *
     * Ответ: 1
     *	 1 <=> 2
     *

     */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        homeWork HomeWork = new homeWork();
        HomeWork.setCount_1(0);
        HomeWork.setCount_2(0);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

      
        Thread myThready = new Thread(new Runnable()
        {
            public void run() 
            {
                HomeWork.setResult(HomeWork.lilysHomework(arr));
                int Poboch_Result = HomeWork.getResult();
                System.out.println ("\nКол-во перестановок (побочный поток): " + Poboch_Result);
            }
        });
        myThready.start();


        int Osn_result = HomeWork.getResult();
        System.out.println ("\nКол-во перестановок (основной поток): " + Osn_result);

        scanner.close();

    }
}
