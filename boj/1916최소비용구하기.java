import java.util.*;

class Bus {
    int destination;
    int cost;

    public Bus(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }
}

public class Main {

    private static final int INF = (int) 1e9;

    static int solution(int n, List<List<Bus>> graph, int start, int end) {
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        d[start] = 0;

        PriorityQueue<Bus> pq = new PriorityQueue<>(Comparator.comparingInt(bus -> bus.cost));
        pq.offer(new Bus(start, 0));

        while (!pq.isEmpty()) {
            Bus cur = pq.poll();

            if (d[cur.destination] < cur.cost) continue;

            List<Bus> adjNodeList = graph.get(cur.destination);
            for (Bus adjNode : adjNodeList) {
                int cost = d[cur.destination] + adjNode.cost;
                if (cost < d[adjNode.destination]) {
                    d[adjNode.destination] = cost;
                    pq.offer(new Bus(adjNode.destination, cost));
                }
            }
        }

        return d[end];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 도시의 개수
        int m = sc.nextInt(); // 버스의 개수

        List<List<Bus>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int dep = sc.nextInt();
            int dest = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(dep).add(new Bus(dest, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        System.out.println(solution(n, graph, start, end));
    }

}
