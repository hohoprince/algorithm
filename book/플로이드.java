package main;


import java.util.*;

public class Main {

    public static int n, m;
    public static int[][] graph;
    public static final int INF = (int) 1e9;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int destination = sc.nextInt();
            int cost = sc.nextInt();

            if (cost < graph[start][destination]) {
                graph[start][destination] = cost;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = graph[i][j];
                if (cost == INF) {
                    System.out.print("0 ");
                } else {
                    System.out.print(cost + " ");
                }
            }
            System.out.println();
        }

    }

}

/*
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
 */
