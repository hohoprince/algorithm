import java.util.*;

public class Main {

    static int[][] board;
    static int[] answer = new int[3];

    static void solution(int x, int y, int size) {
        int num = board[x][y];
        boolean same = true;

        loop: for (int i = x; i < size + x; i++) {
            for (int j = y; j < size + y; j++) {
                if (num != board[i][j]) {
                    same = false;
                    break loop;
                }
            }
        }

        if (same) {
            if (num == -1) {
                answer[0]++;
            } else if (num == 0) {
                answer[1]++;
            } else {
                answer[2]++;
            }
        } else {
            int s = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    solution(x + s * i, y + s * j, s);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        solution(0,0, n);

        for (int x : answer) {
            System.out.println(x);
        }
    }

}
