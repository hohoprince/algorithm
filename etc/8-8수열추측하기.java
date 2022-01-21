import java.util.*;

public class Main {

    static int n;
    static int f;
    static int[] b;
    static int[] p;
    static boolean flag;
    static boolean[] ch;
    static int[][] memo = new int[35][35];

    public int combination(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        }

        if (memo[n][r] != 0) {
            return memo[n][r];
        }

        return memo[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }

    public void dfs(int l, int sum) {
        if (flag) return;

        if (l == n) {
            if (sum == f) {
                for (int x : p) {
                    System.out.print(x + " ");
                    flag = true;
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    p[l] = i;
                    dfs(l + 1, sum + p[l] * b[l]);
                    ch[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();

        b = new int[n];
        p = new int[n];
        ch = new boolean[n + 1];


        for (int i = 0; i < n; i++) {
            b[i] = T.combination(n - 1, i);
        }
        T.dfs(0 , 0);

    }
}

