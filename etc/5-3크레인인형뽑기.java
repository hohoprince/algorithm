import java.util.*;

public class Main {

    public int pop(int n, int[][] board, int move) {
        for (int i = 0; i < n; i++) {
            if (board[i][move - 1] != 0) {
                int doll = board[i][move - 1];
                board[i][move - 1] = 0;
                return doll;
            }
        }
        return -1;
    }

    public int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int x : moves) {
            int doll = pop(n, board, x);
            if (doll == -1) continue;

            if (!stack.isEmpty() && stack.peek() == doll) {
                answer += 2;
                stack.pop();
            } else {
                stack.push(doll);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, board, m, moves));
    }
}
