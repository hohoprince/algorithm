package main;

import java.util.*;


public class Main {

    public static int n;
    public static int[] inDegree = new int[501];
    public static List<List<Integer>> graph = new ArrayList<>();
    public static int[] times = new int[501];

    public static void topologySort() {
        int[] result = new int[501];
        for (int i = 1; i <= n; i++) {
            result[i] = times[i];
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)],
                        result[now] + times[graph.get(now).get(i)]);
                inDegree[graph.get(now).get(i)] -= 1;

                if (inDegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }

        }

        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            times[i] = x;

            while (true) {
                x = sc.nextInt();
                if (x == -1) break;
                inDegree[i] += 1;
                graph.get(x).add(i);
            }
        }

        topologySort();

    }
}

/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
 */
