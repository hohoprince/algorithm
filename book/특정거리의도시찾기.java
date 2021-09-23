package main;

import java.util.*;

public class Main {

    public static int n, m, k, x;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static int[] costs = new int[300001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();


        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            costs[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int dest = sc.nextInt();
            graph.get(start).add(dest);
        }

        q.offer(x);
        costs[x] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int n : graph.get(now)) {
                if (costs[n] == -1) {
                    costs[n] = costs[now] + 1;
                    q.offer(n);
                }
            }
        }

        boolean isNoAnswer = true;

        for (int i = 1; i < costs.length; i++) {
            if (costs[i] == k) {
                System.out.println(i);
                isNoAnswer = false;
            }
        }

        if (isNoAnswer) System.out.println(-1);

    }

}

/*
4 4 2 1
1 2
1 3
2 3
2 4
 */
