import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution_toy {

    /*
     * Лука и Фекла очень счастливы после рождения первого ребенка.
     * Их сын любит игрушки, поэтому Лука хочет прикупить чего-то.
     * Перед ним лежит ряд различных игрушек с ценами. У Луки есть только
     * определенная сумма, и он хочет максимизировать количество игрушек,
     * которые он покупает на эти деньги. Учитывая список цен и сумму,
     * которую можно потратить, какое максимальное количество игрушек можно купить?
     *
     * k - бюджет
     * 1 <= k <= 10e9
     * 1 <= n <= 10e5, n - количество цен игрушек
     * 1 <= prices[i] <= 10e9
     *
     * Пример: 7 50
     *         1 12 5 111 200 1000 10
     * Ответ: 4
     */

    static int maximumToys(int[] p, int k) {
        int c = 0, sum = 0, N = 0;
        N = p.length;
        Arrays.sort(p);

        for (int i=0;i< N;i++)
            {

            if(sum+p[i]<=k)
            {
                sum = sum+ p[i];
                c++;

            }

        }
        return c;


    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    //    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);
/*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
*/

        System.out.println(result);
        scanner.close();
    }
}