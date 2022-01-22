import java.util.*;

public class Main {

    static int n, m;
    static int[] combination;

    void dfs(int level, int start) {

        if (level == m) {
            for (int x : combination) System.out.print(x + " ");
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            combination[level] = i;
            dfs(level + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        combination = new int[m];

        T.dfs(0, 1);
    }
}

