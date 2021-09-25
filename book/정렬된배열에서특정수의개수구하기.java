package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = arr.length - 1;

        int minIndex = n;
        int maxIndex = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] < x) {
                start = mid + 1;
            } else {
                if (arr[mid] == x) {
                    minIndex = Math.min(minIndex, mid);
                }
                end = mid - 1;
            }
        }

        start = 0;
        end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] > x) {
                end = mid - 1;
            } else {
                if (arr[mid] == x) {
                    maxIndex = Math.max(maxIndex, mid);
                }
                start = mid + 1;
            }
        }

        int result = maxIndex - minIndex + 1;

        if (result < 1) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

}

/*
7 2
1 1 2 2 2 2 3
 */
