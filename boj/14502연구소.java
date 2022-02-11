import java.util.*;

public class Main {

    static int n;
    static int m;
    static int maxValue = Integer.MIN_VALUE;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void virus(int x, int y, int[][] board) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                board[nx][ny] = 2;
                virus(nx, ny, board);
            }
        }
    }

    static void infect(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    virus(i, j, board);
                }
            }
        }
    }

    static int getAnswer(int[][] board) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int count, int[][] board) {
        if (count == 3) {
            int[][] newBoard = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    newBoard[i][j] = board[i][j];
                }
            }
            infect(newBoard);
            maxValue = Math.max(maxValue, getAnswer(newBoard));
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    dfs(count + 1, board);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        dfs(0, board);

        System.out.println(maxValue);

    }

    static void print(int[][] board) {
        for (int[] x : board) {
            System.out.println(Arrays.toString(x));
        }
        System.out.println();
    }

}
