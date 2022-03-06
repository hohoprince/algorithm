import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;
    int isBreak; // 0: 안부숨, 1: 부숨

    public Point(int x, int y, int isBreak) {
        this.x = x;
        this.y = y;
        this.isBreak = isBreak;
    }
}

public class Main {

    private static int solution(int n, int m, int[][] map) {

        Queue<Point> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[2][n][m];

        final int[] dx = {0, 1, 0, -1};
        final int[] dy = {1, 0, -1, 0};
        
        map[n - 1][m - 1] = Integer.MAX_VALUE;
        map[0][0] = 1;
        
        visited[0][0][0] = true;

        queue.offer(new Point(0, 0, 0));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == -1) { // 벽
                        if (cur.isBreak == 0 && !visited[1][nx][ny]) { // 벽을 부수지 않았고 부순적이 없으면 부수기
                            visited[0][nx][ny] = true;
                            map[nx][ny] = map[cur.x][cur.y] + 1;
                            queue.offer(new Point(nx, ny, 1));
                        }
                    } else { // 벽이 아님
                        if (!visited[cur.isBreak][nx][ny]) { // 방문하지 않음
                            visited[cur.isBreak][nx][ny] = true;
                            if (nx == n - 1 && ny == m - 1) {
                                map[nx][ny] = Math.min(map[nx][ny], map[cur.x][cur.y] + 1);
                            } else {
                                map[nx][ny] = map[cur.x][cur.y] + 1;
                            }
                            queue.offer(new Point(nx, ny, cur.isBreak));
                        }
                    }
                }
            }
        }

        return map[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : map[n - 1][m - 1];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                int num = s.charAt(j) - '0';
                map[i][j] = num == 1 ? -1 : num;
            }
        }

        System.out.println(solution(n, m, map));
    }

}
