import java.util.*;

class Point {
    int x;
    int y;
    int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    static void print(int[][][] container, int m, int n, int h) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    System.out.printf("%2d", container[j][k][i]);
                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }

    static int solution(int m, int n, int h, int[][][] container) {
        int[] dx = {0, 1, 0, -1, 0, 0};
        int[] dy = {1, 0, -1, 0, 0 ,0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (container[j][k][i] == 1) {
                        queue.offer(new Point(j, k, i));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int d = 0; d < 6; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nz = cur.z + dz[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h
                        && container[nx][ny][nz] == 0) {
                    container[nx][ny][nz] = container[cur.x][cur.y][cur.z] + 1;
                    queue.offer(new Point(nx, ny, nz));
                }
            }
        }

        int max = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (container[j][k][i] == 0) {
                        return -1;
                    } else {
                        max = Math.max(max, container[j][k][i]);
                    }
                }
            }
        }

        return max - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();

        int[][][] container = new int[n][m][h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    container[j][k][i] = sc.nextInt();
                }
            }
        }

        System.out.println(solution(m, n, h, container));
    }
}
