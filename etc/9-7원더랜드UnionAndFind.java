import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    static int[] parents;

    void union(int a, int b) {
        a = find(a);
        b= find(b);
        if (a < b) parents[b] = a;
        else parents[a] = b;
    }

    int find(int x) {
        if (x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }

    int solution(int v, List<Edge> edges) {
        edges.sort((n1, n2) -> n1.cost - n2.cost);

        int totalCost = 0;

        int count = 0;

        for (Edge edge : edges) {
            if (count == v - 1) break;
            if (find(edge.a) != find(edge.b)) {
                count++;
                union(edge.a, edge.b);
                totalCost += edge.cost;
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        List<Edge> edges = new ArrayList<>();

        parents = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(a, b, cost));
        }

        System.out.println(T.solution(v, edges));

    }
}
