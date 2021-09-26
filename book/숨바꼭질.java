package main;


import java.util.*;


class Node implements Comparable<Node> {
    private int num;
    private int distance;

    public Node(int num, int distance) {
        this.num = num;
        this.distance = distance;
    }

    public int getNum() {
        return num;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(distance, o.distance);
    }
}

public class Main {

    public static final int INF = (int) 1e9;
    public static List<List<Node>> graph;
    public static int d[];

    public static void dijkstra(int start) {
        d[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int num = node.getNum();
            int distance = node.getDistance();

            if (d[num] < distance) continue;

            for (Node adjNode : graph.get(num)) {
                int cost = d[num] + adjNode.getDistance();
                if (cost < d[adjNode.getNum()]) {
                    d[adjNode.getNum()] = cost;
                    pq.offer(new Node(adjNode.getNum(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList<>();
        d = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            d[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int destination = sc.nextInt();
            graph.get(start).add(new Node(destination, 1));
            graph.get(destination).add(new Node(start, 1));
        }

        dijkstra(1);

        System.out.println(Arrays.toString(d));

        int maxValue = 0;
        int maxNode = 0;
        int maxCount = 0;

        for (int i = 1; i < d.length; i++) {
            if (maxValue < d[i]) {
                maxValue = d[i];
                maxNode = i;
                maxCount = 1;
            } else if (maxValue == d[i]) {
                maxCount++;
            }
        }

        System.out.println(maxNode + " " + maxValue + " " + maxCount);

    }

}

/*
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
 */
