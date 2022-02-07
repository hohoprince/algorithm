import java.util.*;

class Robot {
    int x;
    int y;
    int direction;
    int cleanCount;

    public Robot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.cleanCount = 0;
    }

    public void clean(boolean[][] cleaned) {
        cleaned[this.x][this.y] = true;
        this.cleanCount++;
    }

    public void rotate() {
        this.direction = this.direction - 1 < 0 ? 3 : this.direction - 1;
    }
}

public class Main {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int solution(int n, int m, int[][] field, Robot robot) {
        boolean[][] cleaned = new boolean[n][m];
        boolean clean = true;

        while (true) {
            // 1번
            if (clean) {
                robot.clean(cleaned);
            }

            // 2번
            boolean search = false;
            for (int i = 0; i < 4; i++) { // 4 방향 회전하면 탐색
                robot.rotate();

                int nx = robot.x + dx[robot.direction];
                int ny = robot.y + dy[robot.direction];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && field[nx][ny] == 0 && !cleaned[nx][ny]) { // 청소 가능
                    robot.x = nx;
                    robot.y = ny;
                    clean = true;
                    search = true;
                    break;
                }
            }

            if (!search) { // 모든 방향이 청소가 되었거나 벽
                int rearDirection = robot.direction - 2 < 0 ? robot.direction + 2 : robot.direction - 2;
                int nx = robot.x + dx[rearDirection];
                int ny = robot.y + dy[rearDirection];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && field[nx][ny] == 0) { // 후진 가능
                    robot.x = nx;
                    robot.y = ny;
                    clean = false;
                } else { // 후진 불가능
                    return robot.cleanCount;
                }
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int direction = sc.nextInt();

        int[][] field = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field[i][j] = sc.nextInt();
            }
        }

        Robot robot = new Robot(startX, startY, direction);

        System.out.println(solution(n, m, field, robot));

    }
}
