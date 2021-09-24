package main;


import java.util.Scanner;

public class Main {

    public static int n;
    public static int[] nums;
    public static int[] operators;
    public static int maxValue = Integer.MIN_VALUE;
    public static int minValue = Integer.MAX_VALUE;

    public static void backtrack(int value, int index) {
        if (index == n) {
            maxValue = Math.max(maxValue, value);
            minValue = Math.min(minValue, value);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0:
                        backtrack(value + nums[index], index + 1);
                        break;
                    case 1:
                        backtrack(value - nums[index], index + 1);
                        break;
                    case 2:
                        backtrack(value * nums[index], index + 1);
                        break;
                    case 3:
                        backtrack(value / nums[index], index + 1);
                }
                operators[i]++;
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new int[n];
        operators = new int[4];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        backtrack(nums[0], 1);

        System.out.println(maxValue);
        System.out.println(minValue);
    }

}

/*
2
5 6
0 0 1 0

3
3 4 5
1 0 1 0

6
1 2 3 4 5 6
2 1 1 1
 */
