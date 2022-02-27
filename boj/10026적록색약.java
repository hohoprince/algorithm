import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static void dfs(int x, int y, int n, char[][] board, boolean[][] visited, char c) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n &&
                    board[nx][ny] == c && !visited[nx][ny]) {
                dfs(nx, ny, n, board, visited, c);
            }

        }
    }

    static void dfs2(int x, int y, int n, char[][] board, boolean[][] visited) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n &&
                    (board[nx][ny] == 'R' || board[nx][ny] == 'G')
                    && !visited[nx][ny]) {
                dfs2(nx, ny, n, board, visited);
            }

        }
    }

    static int[] solution(int n, char[][] board) {
        int[] answer = new int[2];

        boolean[][] visited = new boolean[n][n];
        int blueCount = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, n, board, visited, board[i][j]);
                    count++;
                    if (board[i][j] == 'B') {
                        blueCount++;
                    }
                }

            }
        }

        answer[0] = count;
        count = 0;
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && (board[i][j] == 'R' || board[i][j] == 'G')) {
                    dfs2(i, j, n, board, visited);
                    count++;
                }

            }
        }

        answer[1] = count + blueCount;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int[] answer = solution(n, board);

        System.out.println(answer[0] + " " + answer[1]);
    }
}
