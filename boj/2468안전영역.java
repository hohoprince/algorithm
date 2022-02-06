import java.util.*;

public class Main {

    static int n;
    static int[][] field;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;

    static void dfs(int x, int y, int limit) {
        visit[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny] && field[nx][ny] > limit) {
                dfs(nx, ny, limit);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        field = new int[n][n];
        visit = new boolean[n][n];

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                field[i][j] = num;
                maxValue = Math.max(maxValue, num);
                minValue = Math.min(minValue, num);
            }
        }

        int answer = 1;

        for (int limit = minValue; limit <= maxValue; limit++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (field[i][j] > limit && !visit[i][j]) {
                        dfs(i, j, limit);
                        count++;
                    }
                }
            }

            answer = Math.max(answer, count);

            for (boolean[] x : visit){
                Arrays.fill(x, false);
            }
        }

        System.out.println(answer);

    }
}
