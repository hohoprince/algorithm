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

    static int l;
    static int r;
    static int c;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static int bfs(Point startPoint, char[][][] building) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(startPoint);
        boolean[][][] visit = new boolean[l][r][c];

        int length = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Point curPoint = queue.poll();

                if (building[curPoint.x][curPoint.y][curPoint.z] == 'E') {
                    return length;
                }

                for (int d = 0; d < 6; d++) {
                    int nx = curPoint.x + dx[d];
                    int ny = curPoint.y + dy[d];
                    int nz = curPoint.z + dz[d];

                    if (nx >= 0 && nx < l && ny >= 0 && ny < r && nz >= 0 && nz < c
                            && building[nx][ny][nz] != '#' && !visit[nx][ny][nz]) {
                        queue.offer(new Point(nx, ny, nz));
                        visit[nx][ny][nz] = true;
                    }
                }
            }
            length++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            l = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();

            if (l == 0 && r == 0 && c == 0) break;

            char[][][] building = new char[l][r][c];
            Point startPoint = null;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String s = sc.next();
                    for (int k = 0; k < c; k++) {
                        building[i][j][k] = s.charAt(k);
                        if (building[i][j][k] == 'S') {
                            startPoint = new Point(i, j, k);
                        }
                    }
                }
            }
            int answer = bfs(startPoint, building);
            System.out.println(answer == -1 ? "Trapped!" : String.format("Escaped in %d minute(s).", answer));
        }

    }
}
