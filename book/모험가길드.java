package main;

import java.util.*;


public class Main {

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        Arrays.sort(nums);

        int result = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            count++;
            if (count >= nums[i]) {
                result++;
                count = 0;
            }

        }

        System.out.println(result);

    }
}

/*
5
2 3 1 2 2
 */
