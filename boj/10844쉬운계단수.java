import java.util.*;

public class Main {

    static int solution(int n) {
        int[][] counts = new int[10][n + 1];

        for (int i = 1; i <= 9; i++) {
            counts[i][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            counts[0][i] = counts[1][i - 1];
            counts[9][i] = counts[8][i - 1];
            for (int j = 1; j < 9; j++) {
                counts[j][i] = (counts[j - 1][i - 1] + counts[j + 1][i - 1]) % 1_000_000_000;
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + counts[i][n]) % 1_000_000_000;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(solution(n));
    }
}
