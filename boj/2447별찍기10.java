package main;


import java.util.*;

public class Main {

    private static char[][] stars;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        stars = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(stars[i], ' ');
        }

        makeStars(n, 0, 0);

        for (char[] star : stars) {
            System.out.println(star);
        }

    }

    private static void makeStars(int n, int x, int y) {
        if (n == 1) {
            stars[x][y] = '*';
            return;
        }

        int nextN = n / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                makeStars(nextN, x + nextN * i, y + nextN * j);
            }
        }
    }
}
