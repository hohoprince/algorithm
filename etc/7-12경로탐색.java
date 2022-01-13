import java.util.*;

public class Main {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int answer = 0;
    static int target = 5;

    public void backtrack(int node) {
        if (node == target) {
            answer++;
        } else {
            for (int adjNode : graph.get(node)) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    backtrack(adjNode);
                    visited[adjNode] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();

        visited = new boolean[6];
        graph = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(2).add(5);

        graph.get(3).add(4);

        graph.get(4).add(2);
        graph.get(4).add(5);

        visited[1] = true;
        T.backtrack(1);

        System.out.println(answer);

    }
}
