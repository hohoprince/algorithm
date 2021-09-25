package main;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] tri = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                tri[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    tri[i][j] += tri[i - 1][j];
                } else if (j == i) {
                    tri[i][j] += tri[i - 1][j - 1];
                } else {
                    tri[i][j] += Math.max(tri[i - 1][j], tri[i - 1][j - 1]);
                }
            }
        }

        int maxValue = 0;

        for (int j = 0; j < n; j++) {
            maxValue = Math.max(maxValue, tri[n - 1][j]);
        }

        System.out.println(maxValue);
    }

}

/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
 */
