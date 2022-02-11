import java.util.*;

class Point {
    int x;
    int y;
    int direction;

    public Point(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}

public class Main {

    static int m, n;
    static int[][] board;
    static boolean[][][] visited;

    // 0: 북, 1: 동, 2: 남, 3: 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    static int convertDir(int x) {
        if (x == 1) {
            return 1;
        } else if (x == 2) {
            return 3;
        } else if (x == 3) {
            return 2;
        } else {
            return 0;
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static int bfs(int x, int y, int direction, int endX, int endY, int endDir) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y, direction));
        int count = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                Point current = queue.poll();

                if (visited[current.x][current.y][current.direction]) continue;

                if (current.x == endX && current.y == endY
                        && current.direction == endDir) {
                    return count;
                }

                visited[current.x][current.y][current.direction] = true;

                int nx = current.x + dx[current.direction];
                int ny = current.y + dy[current.direction];
                if (isValid(nx, ny) && board[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny, current.direction));

                    int nx2 = current.x + 2 * dx[current.direction];
                    int ny2 = current.y + 2 * dy[current.direction];
                    if (isValid(nx2, ny2) && board[nx2][ny2] == 0) {
                        queue.offer(new Point(nx2, ny2, current.direction));

                        int nx3 = current.x + 3 * dx[current.direction];
                        int ny3 = current.y + 3 * dy[current.direction];
                        if (isValid(nx3, ny3) && board[nx3][ny3] == 0) {
                            queue.offer(new Point(nx3, ny3, current.direction));
                        }
                    }
                }
                int leftDir = current.direction == 0 ? 3 : current.direction - 1;
                int rightDir = (current.direction + 1) % 4;
                queue.offer(new Point(current.x, current.y, leftDir));
                queue.offer(new Point(current.x, current.y, rightDir));
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[m][n];
        visited = new boolean[m][n][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int startX = sc.nextInt() - 1;
        int startY = sc.nextInt() - 1;
        int startDir = convertDir(sc.nextInt());
        int endX = sc.nextInt() - 1;
        int endY = sc.nextInt() - 1;
        int endDir = convertDir(sc.nextInt());

        System.out.println(bfs(startX, startY, startDir, endX, endY, endDir));
    }
}
