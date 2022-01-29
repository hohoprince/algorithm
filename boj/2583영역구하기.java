import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] map;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int dfs(int x, int y) {
        map[x][y] = 1;

        int sum = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 1) {
                sum += dfs(nx, ny);
            }
        }

        return sum + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        int k = sc.nextInt();

        map = new int[n][m];

        int count = 0;
        List<Integer> areas = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int j = x1; j < x2; j++) {
                for (int l = y1; l < y2; l++) {
                    map[j][l] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 1) {
                    count++;
                    areas.add(dfs(i, j));
                }
            }
        }

        System.out.println(count);
        areas.sort(Integer::compare);
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }
}
