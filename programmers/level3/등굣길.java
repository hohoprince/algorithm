import java.util.*;

public class Main {

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];

        for (int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        for (int i = 1; i < m; i++) {
            if (map[0][i] == -1) break;
            map[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (map[i][0] == -1) break;
            map[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (map[j][i] == -1) continue;
                int sum = 0;
                if (map[j - 1][i] != -1) sum += map[j - 1][i] ;
                if (map[j][i - 1] != -1) sum += map[j][i - 1];
                map[j][i] = sum % 1_000_000_007;
            }
        }

        System.out.println(Arrays.deepToString(map));

        answer = map[n - 1][m - 1];

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();

        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        System.out.println(M.solution(m, n, puddles));
    }
}

