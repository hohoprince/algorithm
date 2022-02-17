import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int NUM_OF_COLOR = 3;

    static int solution(int n, int[][] costs) {
        int[][] sum = new int[n][NUM_OF_COLOR];

        for (int i = 0; i < NUM_OF_COLOR; i++) {
            sum[0][i] = costs[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < NUM_OF_COLOR; j++) {
                int minCost = Integer.MAX_VALUE;
                for (int k = 0; k < NUM_OF_COLOR; k++) {
                    if (k != j) {
                        minCost = Math.min(minCost, sum[i - 1][k]);
                    }
                }
                sum[i][j] = minCost + costs[i][j];
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < NUM_OF_COLOR; i++) {
            answer = Math.min(answer, sum[n - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] costs = new int[n][NUM_OF_COLOR];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < NUM_OF_COLOR; j++) {
                costs[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(n, costs));

    }
}
