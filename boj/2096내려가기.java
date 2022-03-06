import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] solution(int n, int[][] board) {
        int[] answer = new int[2];

        int[][] maxBoard = new int[n][3];
        int[][] minBoard = new int[n][3];

        for (int i = 0; i < 3; i++) {
            maxBoard[0][i] = board[0][i];
            minBoard[0][i] = board[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    maxBoard[i][0] = board[i][0] + Math.max(maxBoard[i - 1][0],
                            maxBoard[i - 1][1]);
                    minBoard[i][0] = board[i][0] + Math.min(minBoard[i - 1][0],
                            minBoard[i - 1][1]);
                } else if (j == 2) {
                    maxBoard[i][2] = board[i][2] + Math.max(maxBoard[i - 1][2],
                            maxBoard[i - 1][1]);
                    minBoard[i][2] = board[i][2] + Math.min(minBoard[i - 1][2],
                            minBoard[i - 1][1]);
                } else {
                    maxBoard[i][1] = board[i][1] + Math.max(maxBoard[i - 1][1],
                            Math.max(maxBoard[i - 1][0], maxBoard[i - 1][2]));
                    minBoard[i][1] = board[i][1] + Math.min(minBoard[i - 1][1],
                            Math.min(minBoard[i - 1][0], minBoard[i - 1][2]));
                }
            }
        }

        answer[1] = Integer.MAX_VALUE;
        for (int e : maxBoard[n - 1]) {
            answer[0] = Math.max(answer[0], e);
        }
        for (int e : minBoard[n - 1]) {
            answer[1] = Math.min(answer[1], e);
        }

        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());

            int[][] board = new int[n][3];

            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    board[i][j] = Integer.parseInt(s[j]);
                }
            }

            int[] answer = solution(n, board);

            System.out.println(answer[0] + " " + answer[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
