import java.util.*;

public class Main {

    static Set<String> set;
    static int[][] board = new int[5][5];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y, StringBuilder sb, int depth) {
        if (depth == 6) {
            set.add(sb.toString());
            return;
        }

        sb.append(board[x][y]);

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                dfs(nx, ny, sb, depth + 1);
            }
        }

        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        set = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, new StringBuilder(), 0);
            }
        }

        System.out.println(set.size());
    }

}
