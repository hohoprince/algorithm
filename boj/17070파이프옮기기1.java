import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Pipe {
    Point point;
    Direction direction;

    public Pipe(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    enum Direction {
        HORIZONTAL, // 가로
        VERTICAL, // 세로
        DIAGONAL // 대각선
    }
}

public class Main {

    // 오른쪽, 아래, 대각선
    private static final int[] dx = {0, 1, 1};
    private static final int[] dy = {1, 0, 1};

    private static int n;
    private static int[][] house;

    private static boolean validate(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n && house[x][y] != 1;
    }

    private static void goToDiagonal(Queue<Pipe> queue, Pipe cur) {
        boolean validation = true;

        for (int d = 0; d < 3; d++) {
            int nx = cur.point.x + dx[d];
            int ny = cur.point.y + dy[d];
            if (!validate(nx, ny)) {
                validation = false;
                break;
            }
        }

        if (validation) {
            queue.offer(new Pipe(new Point(cur.point.x + 1, cur.point.y + 1),
                    Pipe.Direction.DIAGONAL));
        }
    }

    private static void goToRight(Queue<Pipe> queue, Pipe cur) {
        int nx = cur.point.x + dx[0];
        int ny = cur.point.y + dy[0];
        if (validate(nx, ny)) {
            queue.offer(new Pipe(new Point(nx, ny), Pipe.Direction.HORIZONTAL));
        }
    }

    private static void goToDown(Queue<Pipe> queue, Pipe cur) {
        int nx = cur.point.x + dx[1];
        int ny = cur.point.y + dy[1];
        if (validate(nx, ny)) {
            queue.offer(new Pipe(new Point(nx, ny), Pipe.Direction.VERTICAL));
        }
    }

    private static int solution() {
        Queue<Pipe> queue = new LinkedList<>();
        queue.offer(new Pipe(new Point(0, 1), Pipe.Direction.HORIZONTAL));

        int answer = 0;

        while (!queue.isEmpty()) {
            Pipe cur = queue.poll();

            if (cur.point.x == n - 1 && cur.point.y == n - 1) {
                answer++;
                continue;
            }

            goToDiagonal(queue, cur);

            switch (cur.direction) {
                case HORIZONTAL:
                    goToRight(queue, cur);
                    break;

                case VERTICAL:
                    goToDown(queue, cur);
                    break;

                case DIAGONAL:
                    goToRight(queue, cur);
                    goToDown(queue, cur);
                    break;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        house = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                house[i][j] = sc.nextInt();
            }
        }

        if (house[n - 1][n - 1] == 1) {
            System.out.println(0);
            return;
        }

        System.out.println(solution());
    }
}
