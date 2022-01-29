import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n;
    static int[][] map;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    static int dfs(int x, int y) {
        int sum = 0;

        map[x][y] = 0;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1) {
                sum += dfs(nx, ny);
            }
        }

        return sum + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int count = 0;
        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    count++;
                    answers.add(dfs(i, j));
                }
            }
        }

        System.out.println(count);
        answers.sort(Integer::compare);
        answers.forEach(System.out::println);
    }
}
