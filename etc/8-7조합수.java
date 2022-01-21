import java.util.*;

public class Main {

    static int[][] memo;

    public int combination(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        }

        if (memo[n][r] != 0) {
            return memo[n][r];
        }

        return memo[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        memo = new int[n + 1][r + 1];

        System.out.println(T.combination(n, r));
    }
}

