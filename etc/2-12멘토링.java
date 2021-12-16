import java.util.*;

public class Main {

    public boolean isMentor(int n, int m, int cur, int target, int[][] arr) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == cur) break;
                if (arr[i][j] == target) return false;
            }
        }
        return true;
    }

    public int solution(int n, int m, int[][] arr) {
        int answer = 0;

        for (int cur = 1; cur <= n; cur++) {
            for (int target = 1; target <= n; target++) {
                if (cur == target) continue;
                if (isMentor(n, m, cur, target, arr)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(n, m, arr));
    }
}
