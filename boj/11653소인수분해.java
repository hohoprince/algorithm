package main;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num = n;

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

        for (int i = 2; i <= num; i++) {
            if (arr[i] && n % i == 0) {
                System.out.println(i);
                n /= i;
                i--;
            }
        }

    }
}
