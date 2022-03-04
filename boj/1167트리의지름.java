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

    static int maxNum = 0;
    static int maxValue = 0;

    static void dfs(List<List<Edge>> graph, boolean[] visited, int num, int sum) {
        if (maxValue < sum) {
            maxValue = sum;
            maxNum = num;
        }

        for (Edge adjEdge : graph.get(num)) {
            if (!visited[adjEdge.num]) {
                visited[adjEdge.num] = true;
                dfs(graph, visited, adjEdge.num, sum + adjEdge.cost);
                visited[adjEdge.num] = false;
            }
        }
    }

    static int solution(List<List<Edge>> graph, int n) {
        boolean[] visited = new boolean[n + 1];

        visited[1] = true;
        dfs(graph, visited, 1, 0);

        visited = new boolean[n + 1];
        visited[maxNum] = true;
        maxValue = 0;
        dfs(graph, visited, maxNum, 0);

        return maxValue;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = 0;
        List<List<Edge>> graph = new ArrayList<>();

        try {
            v = Integer.parseInt(br.readLine());

            for (int i = 0; i < v + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 1; i <= v; i++) {
                List<Edge> tmp = new ArrayList<>();
                String[] s = br.readLine().split(" ");
                for (int j = 1; j < s.length - 1; j += 2) {
                    int num = Integer.parseInt(s[j]);
                    int cost = Integer.parseInt(s[j + 1]);
                    tmp.add(new Edge(num, cost));
                }
                int start = Integer.parseInt(s[0]);
                graph.set(start, tmp);
            }

            System.out.println(solution(graph, v));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
