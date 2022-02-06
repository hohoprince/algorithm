import java.util.*;

public class Main {

    static int minCount = 4;

    // i번 세로선의 결과가 i번이 나오는지 여부를 체크
    static boolean check(int n, int h, boolean[][] ladder) {
        for (int i = 0; i < n; i++) {
            int curNum = i;
            for (int j = 0; j < h; j++) {
                if (ladder[j][curNum]) {
                    curNum++;
                } else if (curNum > 0 && ladder[j][curNum - 1]) {
                    curNum--;
                }
            }
            if (i != curNum) {
                return false;
            }
        }
        return true;
    }

    // 다리를 limit 만큼 놓은 후 체크
    static void dfs(int n, int h, boolean[][] newLadder, int count, int limit) {
        if (count == limit) {
            if (check(n, h, newLadder)) {
                minCount = Math.min(minCount, count);
            }
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < h; j++) {
                if (i > 0 && newLadder[j][i - 1]) continue;
                if (newLadder[j][i + 1]) continue;

                if (!newLadder[j][i]) {
                    newLadder[j][i] = true;
                    dfs(n, h, newLadder, count + 1, limit);
                    newLadder[j][i] = false;
                }
            }
        }
    }

    static int solution(int n, int h, boolean[][] ladder) {
        if (check(n, h, ladder)) {
            return 0;
        }

        for (int limitCount = 1; limitCount <= 3; limitCount++) {
            boolean[][] newLadder = ladder.clone();
            dfs(n, h, newLadder, 0, limitCount);
        }

        if (minCount == 4) {
            return -1;
        }
        return minCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int h = sc.nextInt();

        boolean[][] ladder = new boolean[h][n];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            ladder[a - 1][b - 1] = true;
        }

        System.out.println(solution(n, h, ladder));
    }
}
