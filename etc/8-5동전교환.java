import java.util.*;

public class Main {

    static int n;
    static int m;
    static Integer[] arr;
    static int answer = Integer.MAX_VALUE;

    public void dfs(int sum, int count) {
        if (sum > m) {
            return;
        }
        if (count >= answer) {
            return;
        }
        if (sum == m) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < n; i++) {
            dfs(sum + arr[i], count + 1);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());

        T.dfs(0, 0);

        System.out.println(answer);
    }
}

