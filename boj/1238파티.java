import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int num;
    int cost;

    public Edge(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "num=" + num +
                ", cost=" + cost +
                '}';
    }
}

public class Main {

    static int[] dijkstra(int start, int n, List<List<Edge>> graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (d[cur.num] < cur.cost) continue;

            for (int i = 0; i < graph.get(cur.num).size(); i++) {
                Edge adjEdge = graph.get(cur.num).get(i);
                int cost = d[cur.num] + adjEdge.cost;
                if (cost < d[adjEdge.num]) {
                    d[adjEdge.num] = cost;
                    pq.offer(new Edge(adjEdge.num, cost));
                }
            }
        }

        return d;
    }

    static int solution(List<List<Edge>> graph, int x, int n) {
        int[] fromX = dijkstra(x, n, graph);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (i != x) {
                int[] fromI = dijkstra(i, n, graph);
                int dist = fromI[x] + fromX[i];
                max = Math.max(max, dist);
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int x  = Integer.parseInt(input[2]);

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            graph.get(start).add(new Edge(end, cost));
        }

        System.out.println(solution(graph, x, n));

    }
}
