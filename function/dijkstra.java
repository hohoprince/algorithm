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
        return this.distance - node.distance;
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
            Node curNode = pq.poll();
            int curNumber = curNode.index;
            int dist = curNode.distance;

            if (d[curNumber] < dist) continue;

            for (int i = 0; i < graph.get(curNumber).size(); i++) {
                Node adjNode = graph.get(curNumber).get(i);
                int cost = d[curNumber] + adjNode.distance;
                if (cost < d[adjNode.index]) {
                    d[adjNode.index] = cost;
                    pq.offer(new Node(adjNode.index, cost));
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
            System.out.print(i + ": ");
            if (d[i] == INF) {
                System.out.println("Infinity");
            } else {
                System.out.println(d[i]);
            }
        }

    }
}
/*
6 9 1
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
*/

