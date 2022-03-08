import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int[] solution(int m, int[][] section, int[][] area) {
        int[] answer = new int[m];

        for (int i = 0; i < m; i++) {
            int x1 = section[i][0];
            int y1 = section[i][1];
            int x2 = section[i][2];
            int y2 = section[i][3];

            answer[i] = area[x2][y2] - area[x2][y1 - 1] - area[x1 - 1][y2] + area[x1 - 1][y1 - 1];
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] board = new int[n][n];
        int[][] section = new int[m][4];
        int[][] area = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                area[i][j] = area[i][j - 1] + area[i - 1][j] - area[i - 1][j - 1] + board[i - 1][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            section[i][0] = Integer.parseInt(s1[0]);
            section[i][1] = Integer.parseInt(s1[1]);
            section[i][2] = Integer.parseInt(s1[2]);
            section[i][3] = Integer.parseInt(s1[3]);
        }

        int[] answer = solution(m, section, area);

        for (int x : answer) {
            System.out.println(x);
        }

    }
}
