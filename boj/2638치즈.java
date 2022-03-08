import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    private static boolean isEmpty(int n, int m, int[][] container) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (container[i][j] == 1) return false;
            }
        }

        return true;
    }

    private static void dfs(int x, int y, int n, int m,
                            int[][] container, boolean[][] outAir) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && container[nx][ny] == 0 &&
                    outAir[nx][ny] == false) {
                outAir[nx][ny] = true;
                dfs(nx, ny, n, m, container, outAir);
            }
        }
    }

    private static int solution(int n, int m, int[][] container) {
        int answer = 0;

        while (true) {

            if(isEmpty(n, m, container)) {
                return answer;
            }

            boolean[][] outAir = new boolean[n][m];
            outAir[0][0] = true;
            dfs(0, 0, n, m, container, outAir);

            List<Point> removePointList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (container[i][j] == 0) continue;

                    int count = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || nx > n || ny < 0 || ny > m) continue;

                        if (container[nx][ny] == 0 && outAir[nx][ny]) {
                            count++;
                        }
                    }

                    if (count >= 2) {
                        removePointList.add(new Point(i, j));
                    }
                }
            }

            for (Point point : removePointList) {
                container[point.x][point.y] = 0;
            }

            answer++;

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] container = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                container[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(n, m, container));
    }
}

