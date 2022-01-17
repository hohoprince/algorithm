import java.util.*;

public class Main {

    static boolean isYes = false;
    static int total = 0;
    static String answer = "NO";

    public void dfs(int[] arr, int total, int sum, int index) {
        if (isYes) {
            return;
        }
        if (total < 2 * sum) {
            return;
        }
        if (total == 2 * sum) {
            answer = "YES";
            isYes = true;
            return;
        }
        if (index == arr.length) {
            return;
        }

        dfs(arr, total, sum + arr[index], index + 1);
        dfs(arr, total, sum, index + 1);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            total += num;
        }

        T.dfs(arr, total, 0, 0);

        System.out.println(answer);
    }
}

