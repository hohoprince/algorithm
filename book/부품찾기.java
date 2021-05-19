package main;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] targets = new int[m];

        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int target : targets) {
            int result = Arrays.binarySearch(arr, target);
            if (result < 0) {
                System.out.print("no ");
            } else {
                System.out.print("yes ");
            }
        }

    }

}

