import java.util.*;

public class Main {

    static int max = 0;

    public void dfs(int c, int index, int sum, int[] arr) {
        if (c < sum) {
            return;
        }

        max = Math.max(max, sum);

        if (index == arr.length) {
            return;
        }

        dfs(c, index + 1, sum + arr[index], arr);
        dfs(c, index + 1, sum, arr);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        T.dfs(c, 0, 0, arr);

        System.out.println(max);

    }
}

