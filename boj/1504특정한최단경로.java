import java.util.*;

class Node {
    int num;
    int cost;

    public Node(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }
}

public class Main {

    static final int INF = (int) 1e9;

    static int[] dijkstra(List<List<Node>> graph, int start, int n) {
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        d[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (d[cur.num] < cur.cost) continue;

            List<Node> adjNodeList = graph.get(cur.num);
            for (Node adjNode : adjNodeList) {
                int cost = d[cur.num] + adjNode.cost;
                if (d[adjNode.num] > cost) {
                    d[adjNode.num] = cost;
                    pq.offer(new Node(adjNode.num, cost));
                }
            }
        }

        return d;
    }

    static int solution(List<List<Node>> graph, int v1, int v2, int n) {
        int[] fromV1 = dijkstra(graph, v1, n);
        int[] fromV2 = dijkstra(graph, v2, n);
        int answer = -1;

        if (fromV1[1] != INF && fromV1[v2] != INF && fromV2[n] != INF) {
            answer = fromV1[1] + fromV1[v2] + fromV2[n];
        }

        if (fromV2[1] != INF && fromV1[v2] != INF && fromV1[n] != INF) {
            answer = Math.min(answer, fromV2[1] + fromV1[v2] + fromV1[n]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        System.out.println(solution(graph, v1, v2, n));
    }
}
