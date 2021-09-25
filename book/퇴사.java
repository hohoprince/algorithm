package main;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] maxCost = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        int maxValue = 0;

        for (int i = n; i >= 1; i--) {
            int next = i + t[i];

            if (next <= n + 1) {
                 maxCost[i] = Math.max(p[i] + maxCost[next], maxValue);
                 maxValue = maxCost[i];
            } else {
                maxCost[i] = maxValue;
            }
        }

        System.out.println(maxValue);

    }

}

/*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200

10
1 1
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10

10
5 10
5 9
5 8
5 7
5 6
5 10
5 9
5 8
5 7
5 6

10
5 50
4 40
3 30
2 20
1 10
1 10
2 20
3 30
4 40
5 50
 */
