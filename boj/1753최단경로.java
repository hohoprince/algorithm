
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

    private static final int INF = (int) 1e9;

    static int[] solution(List<List<Node>> graph, int v, int e, int start) {
        int[] d = new int[v + 1];
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        int start = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int dep = sc.nextInt();
            int dest = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(dep).add(new Node(dest, cost));
        }

        int[] d = solution(graph, v, e, start);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < v + 1; i++) {
            sb.append(d[i] == INF ? "INF" : d[i]).append("\n");
        }

        System.out.println(sb);
    }
}
