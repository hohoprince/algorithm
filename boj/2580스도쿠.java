import java.util.*;

public class Main {

    static int[][] board;

    static boolean validate(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value || board[i][col] == value) {
                return false;
            }
        }

        int startRowIndex = row - (row % 3);
        int startColIndex = col - (col % 3);

        for (int i = startRowIndex; i < startRowIndex + 3; i++) {
            for (int j = startColIndex; j < startColIndex + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
    
    static String getBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    static void dfs(int row, int col) {
        if (row >= 9) { // 완료
            System.out.println(getBoard());
            System.exit(0);
        }

        if (col >= 9) {
            dfs(row + 1, 0);
            return;
       }

        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (validate(row, col, i)) {
                    board[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            board[row][col] = 0; // 모든 경우가 맞지 않으면 돌아가기위해 다시 0으로 세팅
            return;
        }
        dfs(row, col + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);

    }
}
