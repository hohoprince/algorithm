import java.util.*;

class Edge {
    int a;
    int b;
    int cost;

    public Edge(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
}

public class Main {

    private static int[] parent;

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    private static int solution(int v, List<Edge> edgeList) {
        edgeList.sort(Comparator.comparingInt(edge -> edge.cost));

        int sumOfCost = 0;

        for (Edge e : edgeList) {
            if (find(e.a) != find(e.b)) {
                union(e.a, e.b);
                sumOfCost += e.cost;
            }
        }

        return sumOfCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        List<Edge> edgeList = new ArrayList<>();

        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            edgeList.add(new Edge(a, b, c));
        }

        System.out.println(solution(v, edgeList));
    }
}
