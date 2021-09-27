package main;


import java.util.*;

class Edge implements Comparable<Edge> {
    private int start;
    private int destination;
    private int cost;

    public Edge(int start, int destination, int cost) {
        this.start = start;
        this.destination = destination;
        this.cost = cost;
    }

    public int getStart() {
        return start;
    }

    public int getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(cost, o.cost);
    }
}

public class Main {

    public static int n, m;
    public static int[] parents;
    public static PriorityQueue<Edge> pq;


    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parents[b] = a;
        else parents[a] = b;
    }

    public static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        pq = new PriorityQueue<>();
        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int totalCost = 0;
        int sum = 0;

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int destination = sc.nextInt();
            int cost = sc.nextInt();
            totalCost += cost;

            pq.offer(new Edge(start, destination, cost));
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.getStart()) != find(edge.getDestination())) {
                union(edge.getStart(), edge.getDestination());
                sum += edge.getCost();
            }
        }

        System.out.println(totalCost - sum);

    }

}

/*
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
 */
