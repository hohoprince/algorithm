import java.util.*;

public class Main {

    static boolean[] visited;
    static int[] picked;

    public void dfs(int[] arr, int m, int l) {
        if (l == m) {
            for (int x : picked) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                picked[l] = arr[i];
                dfs(arr, m, l + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        visited = new boolean[n];
        picked = new int[m];

        T.dfs(arr, m, 0);
    }
}

