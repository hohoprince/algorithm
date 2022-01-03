import java.util.*;

public class Main {

    static int n;
    static int[] arr;

    public void dfs(int l) {
        if (l == n + 1) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (arr[i] == 1) tmp.append(i).append(" ");
            }
            if (tmp.length() > 0) System.out.println(tmp);
        } else {
            arr[l] = 1;
            dfs(l + 1);
            arr[l] = 0;
            dfs(l + 1);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n + 1];
        T.dfs(1);

    }
}
