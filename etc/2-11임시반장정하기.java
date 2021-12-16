import java.util.*;

public class Main {

    public int solution(int n, int[][] board) {
        int answer = 0;
        int maxValue = Integer.MIN_VALUE;

        for (int cur = 0; cur < n; cur++) {
            int count = 0;
            for (int target = 0; target < n; target++) {
                for (int i = 0; i < 5; i++) {
                    if (cur == target) break;
                    if (board[cur][i] == board[target][i]) {
                        count++;
                        break;
                    }
                }
            }
            if (count > maxValue) {
                maxValue = count;
                answer = cur + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] board = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(n, board));
    }
}
