import java.util.*;

public class Main {

    public int solution(int n, int[][] edge) {
        int answer = 0;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        int distance = 0;

        int[] distances = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Integer poll = queue.poll();
                distances[poll] = distance;

                for (Integer adjNode : graph.get(poll)) {
                    if (!visited[adjNode]) {
                        visited[adjNode] = true;
                        queue.offer(adjNode);
                    }
                }
            }

            distance++;
        }

        for (int d : distances) {
            if (d == distance - 1) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();

        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(M.solution(n, edge));
    }
}

