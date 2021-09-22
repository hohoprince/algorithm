package main;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[m + 1];

        for (int i = 0; i < n; i++) arr[sc.nextInt()] += 1;

        int count = 0;

        for (int i = 1; i <= m; i++) {
            n -= arr[i];
            count += arr[i] * n;
        }

        System.out.println(count);
    }
}

/*
ex 1
5 3
1 3 2 3 2

ex 2
8 5
1 5 4 3 2 4 5 2
 */
