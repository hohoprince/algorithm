import java.util.*;

class Point {
    int x;
    int y;
    int amount;

    public Point(int x, int y, int amount) {
        this.x = x;
        this.y = y;
        this.amount = amount;
    }
}

public class Main {

    private static int r;
    private static int c;
    private static int t;
    private static int[][] room;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static List<Point> airCleaner;

    private static boolean validate(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    private static void diffuse(Queue<Point> queue) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] > 0) {
                    queue.offer(new Point(i, j, room[i][j]));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            int amount = cur.amount / 5;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (validate(nx, ny) && room[nx][ny] != -1) {
                    room[nx][ny] += amount;
                    room[cur.x][cur.y] -= amount;
                }
            }
        }
    }

    private static void clean(int x, int y, boolean up) {
        int[] cleanerDx;
        int[] cleanerDy = {0, 1, 0, -1};
        int startX = x;

        if (up) {
            cleanerDx = new int[] {-1, 0, 1, 0};
        } else {
            cleanerDx = new int[] {1, 0, -1, 0};
        }

        for (int d = 0; d < 4; d++) {
            while (true) {
                int nx = x + cleanerDx[d];
                int ny = y + cleanerDy[d];

                if (validate(nx, ny)) {
                    if (up && startX < nx) break;
                    if (!up && startX > nx) break;

                    if (room[x][y] == -1) {
                        room[nx][ny] = 0;
                    } else if (room[nx][ny] == -1) {
                        room[x][y] = 0;
                        break;
                    } else {
                        room[x][y] = room[nx][ny];
                    }
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
            }
        }
    }

    private static int solution() {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < t; i++) {
            diffuse(queue);
            clean(airCleaner.get(0).x, airCleaner.get(0).y, true);
            clean(airCleaner.get(1).x, airCleaner.get(1).y, false);
        }

        int answer = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] != -1) {
                    answer += room[i][j];
                }
            }
        }

        return answer;
    }

    static void print(int[][] room) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("%2d ", room[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();

        room = new int[r][c];

        airCleaner = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                room[i][j] = sc.nextInt();
                if (room[i][j] == -1) {
                    airCleaner.add(new Point(i, j, -1));
                }
            }
        }

        System.out.println(solution());
    }
}
