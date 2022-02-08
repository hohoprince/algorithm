import java.util.*;

class MoveInfo {
    int x;
    int y;
    int distance;

    public MoveInfo(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

public class Main {

    static int n, m;
    static char[][] board;

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};


    static MoveInfo move(int x, int y, int direction) {
        int mx = x;
        int my = y;
        int distance = 0;

        while (true) {
            int nx = mx + dx[direction];
            int ny = my + dy[direction];

            if (board[nx][ny] != '#') {
                mx = nx;
                my = ny;
                distance++;
                if (board[nx][ny] == 'O') {
                    break;
                }
            } else {
                break;
            }
        }

        return new MoveInfo(mx, my, distance);
    }

    static void dfs(int redX, int redY, int blueX, int blueY, int depth) {
        if (depth >= 10) return;

        for (int d = 0; d < 4; d++) {
            MoveInfo redMoveInfo = move(redX, redY, d);
            MoveInfo blueMoveInfo = move(blueX, blueY, d);

            if (board[blueMoveInfo.x][blueMoveInfo.y] == 'O') continue;
            if (board[redMoveInfo.x][redMoveInfo.y] == 'O') {
                System.out.println(1);
                System.exit(0);
            }

            if (redMoveInfo.x == blueMoveInfo.x && redMoveInfo.y == blueMoveInfo.y) { // 같은 위치
                int rearDirection = (d + 2) % 4;
                if (redMoveInfo.distance > blueMoveInfo.distance) { // red를 한 칸 뒤로
                    redMoveInfo.x += dx[rearDirection];
                    redMoveInfo.y += dy[rearDirection];
                } else { // blue를 한 칸 뒤로
                    blueMoveInfo.x += dx[rearDirection];
                    blueMoveInfo.y += dy[rearDirection];
                }
            }

            board[redX][redY] = '.';
            board[blueX][blueY] = '.';
            board[redMoveInfo.x][redMoveInfo.y] = 'R';
            board[blueMoveInfo.x][blueMoveInfo.y] = 'B';
            dfs(redMoveInfo.x, redMoveInfo.y, blueMoveInfo.x, blueMoveInfo.y, depth + 1);
            board[redMoveInfo.x][redMoveInfo.y] = '.';
            board[blueMoveInfo.x][blueMoveInfo.y] = '.';
            board[redX][redY] = 'R';
            board[blueX][blueY] = 'B';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];

        int redX = 0, redY = 0, blueX = 0, blueY = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                board[i][j] = c;
                if (c == 'R') {
                    redX = i;
                    redY = j;
                } else if (c == 'B') {
                    blueX = i;
                    blueY = j;
                }
            }
        }

        dfs(redX, redY, blueX, blueY, 0);

        System.out.println(0);
    }
}
