import java.util.*;

public class Main {

    private static final int INF = (int) 1e9;

    private static int solution(int n, int[][] costs, int[] numOfItems, int m) {
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                }
            }
        }

        int answer = 0;

        for (int start = 1; start <= n; start++) {
            int sum = 0;
            for (int dest = 1; dest <= n; dest++) {
                if (costs[start][dest] > m) continue;
                sum += numOfItems[dest];
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();

        int[][] costs = new int[n + 1][n + 1];
        int[] numOfItems = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            numOfItems[i] = sc.nextInt();
        }

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(costs[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            costs[i][i] = 0;
        }


        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            costs[a][b] = c;
            costs[b][a] = c;
        }

        System.out.println(solution(n, costs, numOfItems, m));

    }
}
