import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if (curr.x == 6 && curr.y == 6) break;

            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];
                if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && map[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                    map[nx][ny] = map[curr.x][curr.y] + 1;
                }
            }

        }
        if (map[6][6] != 0) System.out.println(map[6][6]);
        else System.out.println(-1);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        map = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        T.bfs();
    }
}

