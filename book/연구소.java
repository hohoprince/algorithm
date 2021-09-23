package main;

import java.util.*;

public class Main {

    public static int n, m;
    public static int[][] lab;
    public static int[][] newLab;

    public static int[] rowOffsets = {-1, 0, 1, 0};
    public static int[] colOffsets = {0, 1, 0, -1};

    public static int count = 0;
    public static int maxCount = 0;

    public static void infect(int row, int col) {
        for (int d = 0; d < 4; d++) {
            int newRow = row + rowOffsets[d];
            int newCol = col + colOffsets[d];

            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) continue;

            if (newLab[newRow][newCol] == 0) {
                newLab[newRow][newCol] = 2;
                infect(newRow, newCol);
            }
        }

    }

    public static void dfs() {

        if (count == 3) {
            newLab = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    newLab[i][j] = lab[i][j];
                }
            }

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (newLab[row][col] == 2) {
                        infect(row, col);
                    }
                }
            }

            int emptyCount = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (newLab[row][col] == 0) {
                        emptyCount++;
                    }
                }
            }

            maxCount = Math.max(emptyCount, maxCount);

            return;

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    count++;
                    dfs();
                    lab[i][j] = 0;
                    count--;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        lab = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lab[i][j] = sc.nextInt();
            }
        }

        dfs();

        System.out.println(maxCount);

    }

}

/*
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2

8 8
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
 */
