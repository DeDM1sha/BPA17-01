package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    static int activityNotifications(int[] expenditure, int d) {
        int result = 0;
        double D = d;
        for (int i = 0 ; i < (expenditure.length - d); i++) {
            int[] copy = Arrays.copyOfRange(expenditure, i, d + i);
            Arrays.sort(copy);
            int index = (int) Math.round(D / 2);
            double temp;
            if (d % 2 == 1) {
                index--;
                temp = copy[index];

            } else {
                temp = (double)  ((double) copy[index - 1] + (double) copy[index]) / 2;
            }

            if (2 * temp <= expenditure[d + i]) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"));
        String[] nd = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] expenditure = new int[n];

        String[] expenditureItems = bufferedReader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int r = activityNotifications(expenditure, d);
        System.out.println ("Answer: " + r);
        System.out.println ("Answer: " + expenditure[2]);
        bufferedReader.close();
        scanner.close();
    }
}
