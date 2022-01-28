import java.util.Arrays;
import java.util.Scanner;

public class Main {

    int solution(int n, int[] coins, int m) {
        int[] counts = new int[m + 1];
        Arrays.fill(counts, Integer.MAX_VALUE);
        counts[0] = 0;

        for (int num = 1; num <= m; num++) {
            for (int coin : coins) {
                if (num - coin >= 0) {
                    counts[num] = Math.min(counts[num], counts[num - coin] + 1);
                }
            }
        }

        return counts[m];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        System.out.println(T.solution(n, coins, m));
    }
}
