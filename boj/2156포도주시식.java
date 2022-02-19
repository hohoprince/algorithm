import java.util.*;

public class Main {

    static int solution(int n, int[] arr) {
        int[][] score = new int[3][n];

        score[0][0] = arr[0];
        score[1][0] = arr[0];

        for (int i = 1; i < n; i++) {
            score[0][i] = score[1][i - 1] + arr[i];
            score[1][i] = score[2][i - 1] + arr[i];
            score[2][i] = Math.max(score[0][i - 1], Math.max(score[1][i - 1], score[2][i - 1]));
        }

        return Math.max(score[0][n - 1], Math.max(score[1][n - 1], score[2][n - 1]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, arr));
    }
}
