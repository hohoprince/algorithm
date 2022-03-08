import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int solution(int l, int[][] stickers) {
        int answer = 0;

        for (int j = 0; j < l; j++) {
            for (int i = 0; i < 2; i++) {
                int max = 0;
                if (j >= 2) {
                    max = Math.max(max, stickers[0][j - 2]);
                    max = Math.max(max, stickers[1][j - 2]);
                }
                if (j >= 1) {
                    if (i == 0) {
                        max = Math.max(max, stickers[1][j - 1]);
                    } else {
                        max = Math.max(max, stickers[0][j - 1]);
                    }
                }
                stickers[i][j] = max + stickers[i][j];
                answer = Math.max(answer, stickers[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] answer = new int[t];

        for (int i = 0; i < t; i++) {

            int l = sc.nextInt();
            int[][] stickers = new int[2][l];
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < l; k++) {
                    stickers[j][k] = sc.nextInt();
                }
            }

            answer[i] = solution(l, stickers);
        }

        for (int x : answer) {
            System.out.println(x);
        }
    }
}
