package main;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] scores = new int[n];
            int sum = 0;

            for (int j = 0; j < n; j++) {
                int score = sc.nextInt();
                scores[j] = score;
                sum += score;
            }

            int average = sum / n;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (scores[j] > average) {
                    count++;
                }
            }
            System.out.printf("%.3f%%\n", (float) count / n * 100);
        }
    }
}
