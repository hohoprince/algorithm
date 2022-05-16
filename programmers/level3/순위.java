import java.util.*;

public class Main {

    public int solution(int n, int[][] results) {
        int answer = 0;

        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> graph2 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }

        for (int[] result : results) {
            graph.get(result[0]).add(result[1]);
            graph2.get(result[1]).add(result[0]);
        }

        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            Arrays.fill(visited, false);
            sum += dfs(2, graph, visited);
            Arrays.fill(visited, false);
            sum += dfs(2, graph2, visited);
            if (sum - 2 == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private int dfs(int num, List<List<Integer>> graph, boolean[] visited) {
        int sum = 1;

        for (Integer adjNode : graph.get(num)) {
            if (!visited[adjNode]) {
                visited[adjNode] = true;
                sum += dfs(adjNode, graph, visited);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Main M = new Main();

        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(M.solution(n, results));
    }
}

