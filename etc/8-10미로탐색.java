import java.util.*;

public class Main {

    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    void dfs(int x, int y) {
        if (x < 0 || x >= 7 || y < 0 || y >= 7 || map[x][y] == 1) return;
        if (x == 6 && y == 6) answer++;
        map[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny);
        }
        map[x][y] = 0;
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

        T.dfs(0, 0);
        System.out.println(answer);
    }
}

