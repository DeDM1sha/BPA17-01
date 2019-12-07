package com.company;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * ������ ���, ����� ���� ������ ���� ������������, ��� ������ �������� ��������.
 * ���� ����� ������ �� ��������� ��� �������. ������ �� �� ������ ���� ������ ��������
 * ������� ����, ����� ��� ����� �������� � ���?
 * ���������� ������ ��������� ����� �����. ����� ������ ������� ����� ��� �������� �������
 * ����� ���������� ���. ������ "������", ���� ����� ��������� ���� �������� ��������� ����������.
 * sum(|qrr[i] - arr[i - 1]|) -> min
 * ���������� ����������� ���������� ������������, ������� ������ ���� ���������
 * ��� ����, ����� ������� ������ "��������".
 *
 * 1 <= n <= 10e5
 * 1 <= qrr[i] <= 2*10e9
 *
 *
 * ������: 4
 *
 *               2 5 3 1
 *
 *      |(2 - 5)| + |(5 - 3)| + |(3 - 1)| = 7
 *
 *          1 2 3 5
 *
 *      |(1 - 2)| + |(2 - 3)| + |(3 - 5)| = 4
 *
 * �����: 2
 *        1 <=> 2, 2 <=> 5
 *
 * ������: 3
 *         2 3 1
 *
 *      |(2 - 3)| + |(3 - 1)| = 1 + 2 = 3
 *
 *         1 3 2
 *
 *      |(1 - 3)| + |(3 - 2)| = 2 + 1 = 3
 *
 * �����: 1
 *	 1 <=> 2
 *

 */

class homeWork {

    private int Count_1; // ���-�� ������������ �� �����������
    private int Count_2; // ���-�� ������������ �� ��������
    private int Result; // ���������

    public void setCount_1 (int Num) {

        this.Count_1 = Num;

} // ������ ��� Count_1

    public int getCount_1 () {

        return this.Count_1;

    } // ������ ��� Count_1

    public void setCount_2 (int Num) {

        this.Count_2 = Num;

    } // ������ ��� Count_2

    public int getCount_2 () {

        return this.Count_2;

    } // ������ ��� Count_2

    public void setResult (int Num) {

        this.Result = Num;

    } // ������ ��� Result

    public int getResult () {

        return this.Result;

    } // ������ ��� Result

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

        } // ���������� �� �����������

        for (int i = 1; i < Array_2.length; i++) {

            if (Array_2[i] > Array_2[i - 1])
                Count_2++;

            for (int j = i; j > 0 && Array_2[j-1] < Array_2[j];j--) {

                int tmp=Array_2[j-1];
                Array_2[j-1]=Array_2[j];
                Array_2[j]=tmp;

            }

        } // ���������� �� ��������

        return this.Count_1 >= this.Count_2 ? this.Count_2 : this.Count_1;

    }

};



public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static Logger log = Logger.getLogger(Main.class.getName());

    public static int getCorrect_Integer() {

        int numFromUser = 0;
        while (scanner.hasNext()) {
            try {
                numFromUser = scanner.nextInt();
                break;
            }

            catch (NoSuchElementException exp) {
                log.log(Level.SEVERE, "Exception: ", exp);
                System.err.println("Invalid input! Try again:");
                scanner.nextLine();
            }
            System.out.print(": ");
        }

        return numFromUser;

    } // ������� ����������� ����� ����� � ����������

    public static void main(String[] args) throws IOException {

        homeWork HomeWork = new homeWork();
        HomeWork.setCount_1(0);
        HomeWork.setCount_2(0);

        System.out.print ("������� ����������� �������: ");
        int n = getCorrect_Integer ();

        int[] arr = new int[n];


        System.out.println ("������� �������� �������: ");
        for (int i = 0; i < n; i++) {

            arr[i] = getCorrect_Integer();

        }

        System.out.println("���������: ");

        new Thread(() -> {HomeWork.setResult(HomeWork.lilysHomework(arr));  System.out.println ("\n���-�� ������������ (�������� �����): " + HomeWork.getResult()); }).start ();

        int Osn_result = HomeWork.getResult();
        System.out.println ("\n���-�� ������������ (�������� �����): " + Osn_result);

        scanner.close();

    }
}