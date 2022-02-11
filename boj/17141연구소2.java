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

    static int n;
    static int m;
    static int minTime = Integer.MAX_VALUE;
    static List<List<Point>> combination;
    static List<Point> virusPoints;
    static List<Point> tmp;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int virus(int[][] board, List<Point> virusPoints) {
        Queue<Point> queue = new LinkedList<>();

        virusPoints.forEach(point -> {
            queue.offer(point);
            board[point.x][point.y] = 2;
        });

        int time = 0;

        while (!queue.isEmpty()) {
            time++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Point current = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = current.x + dx[d];
                    int ny = current.y + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0) {
                        board[nx][ny] = time;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }

        return time - 1;
    }

    static void setCombination(int start, int limit, int depth) {
        if (depth == limit) {
            combination.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < virusPoints.size(); i++) {
            tmp.add(virusPoints.get(i));
            setCombination(i + 1, limit, depth + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    static boolean isInfect(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    static void solution(int[][] board) {
        combination.forEach(virusPoints -> {
            int[][] newBoard = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    newBoard[i][j] = board[i][j];
                }
            }
            int time = virus(newBoard, virusPoints);
            if (isInfect(newBoard)) {
                minTime = Math.min(minTime, time);
            }
        });
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[][] board = new int[n][n];
        combination = new ArrayList<>();
        virusPoints = new ArrayList<>();
        tmp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                if (num == 2) {
                    virusPoints.add(new Point(i, j));
                    board[i][j] = 0;
                } else {
                    board[i][j] = num;
                }
            }
        }

        setCombination(0, m, 0);
        solution(board);

        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);

    }
}
