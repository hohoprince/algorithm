package main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[arr.length - 1] - arr[0];

        int result = start;

        while (start <= end) {
            int mid = (start + end) / 2;

            int value = arr[0];
            int count = 1;

            for (int i = 1; i < n; i++) {
                if (arr[i] >= value + mid) {
                    count++;
                    value = arr[i];
                }
            }

            if (count >= c) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        System.out.println(result);

    }

}

/*
5 3
1
2
8
4
9
 */
