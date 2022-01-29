import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int r, c;
    static char[][] board;
    static Set<Character> set;
    static int maxDepth = 0;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void dfs(int x, int y, int depth) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !set.contains(board[nx][ny])) {
                set.add(board[nx][ny]);
                dfs(nx, ny, depth + 1);
                set.remove(board[nx][ny]);
            }
        }
        maxDepth = Math.max(maxDepth, depth);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        board = new char[r][c];
        set = new HashSet<>();

        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        set.add(board[0][0]);
        dfs(0, 0, 1);

        System.out.println(maxDepth);

    }
}
