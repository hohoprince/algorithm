import java.util.*;

class Edge {
    int destination;
    int cost;

    public Edge(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }
}

public class Main {

    private static final int INF = (int) 1e9;

    static String solution(int n, List<List<Edge>> graph) {
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        d[1] = 0;

        for (int i = 0; i <= n; i++) {
            for (int from = 1; from <= n; from++) {
                for (Edge edge : graph.get(from)) {
                    if (d[edge.destination] > d[from] + edge.cost) {
                        d[edge.destination] = d[from] + edge.cost;

                        if (i == n) {
                            return "YES";
                        }
                    }
                }
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        List<String> answer = new ArrayList<>();

        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int w = sc.nextInt();

            List<List<Edge>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                graph.get(a).add(new Edge(b, c));
                graph.get(b).add(new Edge(a, c));
            }

            for (int i = 0; i < w; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                graph.get(a).add(new Edge(b, -c));
            }

            answer.add(solution(n, graph));
        }

        for (String s : answer) {
            System.out.println(s);
        }
    }

}
