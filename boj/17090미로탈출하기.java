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

    static int n, m;
    static char[][] board;
    static int count = 0;

    // D, R, U, L 순서
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(Point p) {
        count++;

        for (int d = 0; d < 4; d++) {
            int nx = p.x + dx[d];
            int ny = p.y + dy[d];
            Point newPoint = new Point(nx, ny);

            if (isExit(newPoint)) continue;

            switch (d) {
                case 0: // D
                    if (board[newPoint.x][newPoint.y] == 'U') {
                        dfs(newPoint);
                    }
                    break;
                case 1: // R
                    if (board[newPoint.x][newPoint.y] == 'L') {
                        dfs(newPoint);
                    }
                    break;
                case 2: // U
                    if (board[newPoint.x][newPoint.y] == 'D') {
                        dfs(newPoint);
                    }
                    break;
                default: // L
                    if (board[newPoint.x][newPoint.y] == 'R') {
                        dfs(newPoint);
                    }
            }
        }
    }

    static boolean isExit(Point p) {
        return p.x < 0 || p.x >= n || p.y < 0 || p.y >= m;
    }

    static Point process(Point p) {
        char c = board[p.x][p.y];
        
        switch (c) {
            case 'U':
                return new Point(p.x - 1, p.y);
            case 'R':
                return new Point(p.x, p.y + 1);
            case 'D':
                return new Point(p.x + 1, p.y);
            default:
                return new Point(p.x, p.y - 1);
        }
    }

    static int solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Point point = new Point(i, j);
                Point next = process(point);
                if (isExit(next)) {
                    dfs(point);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        System.out.println(solution());
    }
}
