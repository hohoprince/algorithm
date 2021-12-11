package main;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 1000; // 2부터 1000까지의 모든 수에 대해 소수 판별
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i]) {
                int j = 2;
                while (i * j <= n) {
                    arr[i * j] = false;
                    j++;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i]) System.out.println(i);
        }

    }
}
