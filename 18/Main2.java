package com.company;

import java.io.*;
import java.util.Arrays;

class MyClass {
    int n;
    int d;
    int[] expenditure;
    int result = 0;

    public MyClass() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file1.txt"));
        String[] nd = bufferedReader.readLine().split(" ");

        this.n = Integer.parseInt(nd[0]);
        this.d = Integer.parseInt(nd[1]);
        this.expenditure = new int[n];

        String[] expenditureItems = bufferedReader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            this.expenditure[i] = expenditureItem;
        }
    }

    public void activityNotifications() {
        double D = this.d;
        for (int i = 0 ; i < (this.expenditure.length - d); i++) {
            int[] copy = Arrays.copyOfRange(this.expenditure, i, this.d + i);
            Arrays.sort(copy);
            int index = (int) Math.round(D / 2);
            double temp;
            if (d % 2 == 1) {
                index--;
                temp = copy[index];
            } else {
                temp = (double)  ((double) copy[index - 1] + (double) copy[index]) / 2;
            }
            if (2 * temp <= this.expenditure[d + i]) {
                this.result++;
            }
        }
    }
}

public class Main2 {
    public static void main(String[] args) throws IOException {
        MyClass myObj1 = new MyClass();
        myObj1.activityNotifications();
        System.out.println ("Answer: " + myObj1.result);
    }
}
