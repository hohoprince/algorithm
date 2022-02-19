import java.util.*;

public class Main {


    static int solution(String s1, String s2) {
        int[][] board = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i < s1.length() + 1; i++) {
            char cur = s1.charAt(i - 1);
            for (int j = 1; j < s2.length() + 1; j++) {
                if (cur == s2.charAt(j - 1)) {
                    board[i][j] = board[i - 1][j - 1] + 1;
                } else {
                    board[i][j] = Math.max(board[i - 1][j], board[i][j - 1]);
                }
            }
        }

        return board[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(solution(s1, s2));
    }
}
