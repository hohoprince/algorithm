import java.util.*;

class Edge {
    int num;
    int cost;

    public Edge(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }
}

public class Main {

    private static final int INF = (int) 1e9;

    private static String solution(int n, List<List<Edge>> graph, int start, int dest) {
        int[] d = new int[n + 1];
        int[] trace = new int[n + 1];
        Arrays.fill(d, INF);
        d[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (d[cur.num] < cur.cost) continue;

            List<Edge> edges = graph.get(cur.num);
            for (Edge edge : edges) {
                int cost = d[cur.num] + edge.cost;
                if (d[edge.num] > cost) {
                    d[edge.num] = cost;
                    trace[edge.num] = cur.num;
                    pq.offer(new Edge(edge.num, cost));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(d[dest]).append('\n');

        Stack<Integer> path = new Stack<>();
        int num = dest;
        int count = 0;

        while (true) {
            path.push(num);
            count++;

            if (num == start) break;

            num = trace[num];
        }

        sb.append(count).append('\n');

        while (!path.isEmpty()) {
            sb.append(path.pop()).append(" ");
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        int start = sc.nextInt();
        int dest = sc.nextInt();

        System.out.println(solution(n, graph, start, dest));

    }
}
