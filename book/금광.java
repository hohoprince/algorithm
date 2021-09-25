package main;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        int[] result = new int[testCase];

        for (int t = 0; t < testCase; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] field = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    field[i][j] = sc.nextInt();
                }
            }

            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    if (i == 0) {
                        field[i][j] += Math.max(field[i][j - 1], field[i + 1][j - 1]);
                    } else if (i == n - 1) {
                        field[i][j] += Math.max(field[i][j - 1], field[i - 1][j - 1]);
                    } else {
                        field[i][j] += Math.max(field[i - 1][j - 1],
                                Math.max(field[i][j - 1], field[i + 1][j - 1]));
                    }
                }
            }

            int maxValue = 0;

            for (int i = 0; i < n; i++) {
                maxValue = Math.max(maxValue, field[i][m - 1]);
            }

            result[t] = maxValue;

        }

        for (int n : result) {
            System.out.println(n);
        }

    }

}

/*
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
 */
