package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {

    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node node) {
        if (this.distance < node.distance) {
            return -1;
        }
        return 1;
    }

}

public class Main {

    public static final int INF = (int) 1e9;
    public static int n, m, start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.distance;
            int nowNodeNumber = node.index;

            if (d[nowNodeNumber] < dist) continue;

            for (int i = 0; i < graph.get(nowNodeNumber).size(); i++) {
                Node iNode = graph.get(nowNodeNumber).get(i);
                int cost = d[nowNodeNumber] + iNode.distance;
                if (cost < d[iNode.index]) {
                    d[iNode.index] = cost;
                    pq.offer(new Node(iNode.index, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        for (int i = 1; i <=n; i++) {
            if (d[i] == INF) {
                System.out.println("Infinity");
            } else {
                System.out.println(d[i]);
            }
        }

    }
}

