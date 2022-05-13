import java.util.*;

public class Main {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] matrix = new int[rows][columns];
        int num = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotation(matrix, queries[i]);
        }

        return answer;
    }

    private int rotation(int[][] matrix, int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        if (x1 == x2 || y1 == y2) return 0;

        int tmp = matrix[x1][y1];
        int min = matrix[x1][y1];

        for (int i = x1; i < x2; i++) {
            matrix[i][y1] = matrix[i + 1][y1];
            min = Math.min(min, matrix[i + 1][y1]);
        }
        for (int i = y1; i < y2; i++) {
            matrix[x2][i] = matrix[x2][i + 1];
            min = Math.min(min, matrix[x2][i + 1]);
        }
        for (int i = x2; i > x1; i--) {
            matrix[i][y2] = matrix[i - 1][y2];
            min = Math.min(min, matrix[i - 1][y2]);
        }
        for (int i = y2; i > y1 + 1; i--) {
            matrix[x1][i] = matrix[x1][i - 1];
            min = Math.min(min, matrix[x1][i - 1]);
        }

        matrix[x1][y1 + 1] = tmp;

        return min;
    }

    void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main M = new Main();

        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        System.out.println(Arrays.toString(M.solution(rows, columns, queries)));
    }
}

