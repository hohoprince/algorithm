package main;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) coins[i] = sc.nextInt();
        Arrays.sort(coins);

        int value = 1;

        for (int i = 0; i < n; i++) {
            if (value < coins[i]) break;
            value += coins[i];
        }

        System.out.println(value);

    }
}

/*
5
3 2 1 1 9
 */
