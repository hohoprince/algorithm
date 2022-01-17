import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] arr;

    public void dfs(int l) {
        if (l == m) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                arr[l] = i;
                dfs(l + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        T.dfs(0);

    }
}

