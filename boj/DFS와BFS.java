import java.util.*;


public class Main {

    private static void dfs(List<List<Integer>> graph, int v, List<Integer> arr, boolean[] visited) {
        arr.add(v);

        for (Integer adjNode : graph.get(v)) {
            if (!visited[adjNode]) {
                visited[adjNode] = true;
                dfs(graph, adjNode, arr, visited);
            }
        }
    }

    private static void bfs(List<List<Integer>> graph, int v, int n, List<Integer> arr) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            arr.add(poll);

            for (Integer adjNode : graph.get(poll)) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    queue.offer(adjNode);
                }
            }
        }
    }

    private static String solution(List<List<Integer>> graph, int v, int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        visited[v] = true;
        dfs(graph, v, result, visited);
        bfs(graph, v, n, result);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(" ");
            if (i == result.size() / 2 - 1) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt();
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for (List<Integer> adjNodes : graph) {
            adjNodes.sort(Comparator.naturalOrder());
        }

        System.out.println(solution(graph, v, n));

    }
}

