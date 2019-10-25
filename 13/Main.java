package com.company;
import java.io.IOException;
import java.util.Scanner;

/*
 * Два кенгуру Кеша и Игорь начинают прыгать одновременно, но с разных стартовых позиций: х1 и х2.
 * И имеют разную длину прыжков: v1 и v2.
 * Прыгают в одном направлении. Определить смогут ли они оказаться в
 * одной точке в один момент времении. Если да, то вывести YES, иначе NO.
 * 0 <= x1 <= x2 <= 10000
 * 1 <= v1 <= 10e4
 * 1 <= v2 <= 10e4
 *
 * Пример: 0 3 4 2. Ответ: YES
 */

public class Main {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        while((x1<=1000)&&(x2<=1000)){
            if(x1==x2){
                return "YES";
            }
            else{
                x1+=v1;
                x2+=v2;
            }
        }
        return "NO";
    }
    public static void main(String[] args) throws IOException {
            Scanner str = new Scanner(System.in);
            String[] x1V1X2V2 = str.nextLine().split(" ");
            int x1 = Integer.parseInt(x1V1X2V2[0]);
            int v1 = Integer.parseInt(x1V1X2V2[1]);
            int x2 = Integer.parseInt(x1V1X2V2[2]);
            int v2 = Integer.parseInt(x1V1X2V2[3]);
            String result = kangaroo(x1, v1, x2, v2);
            System.out.println(result);
            str.close();
        }
    }



