import java.util.*;

public class Main {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public boolean isPeaks(int x, int y, int[][] board, int n) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] >= board[x][y]) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int[][] board) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPeaks(i, j, board, n)) answer++;
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

        System.out.println(T.solution(n, board));
    }
}
