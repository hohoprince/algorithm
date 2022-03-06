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

    private static boolean[] visited;
    private static int maxValue = 0;
    private static int maxNum = 0;

    private static void dfs(List<List<Node>> graph, int num, int sum) {

        if (maxValue < sum) {
            maxValue = sum;
            maxNum = num;
        }

        for (Node adjNode : graph.get(num)) {
            if (!visited[adjNode.num]) {
                visited[adjNode.num] = true;
                dfs(graph, adjNode.num, sum + adjNode.cost);
            }
        }
    }

    private static void solution(int n, List<List<Node>> graph) {
        visited[1] = true;
        dfs(graph, 1, 0);

        visited = new boolean[n + 1];
        visited[maxNum] = true;
        maxValue = 0;
        dfs(graph, maxNum, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        solution(n, graph);

        System.out.println(maxValue);

    }

}
