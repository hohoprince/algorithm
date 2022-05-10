import java.util.*;

public class Main {

    boolean[] visited;
    int[][] graph;

    private void dfs(int start, int n) {
        for (int i = 0; i < n; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, n);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        graph = computers;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();

        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(M.solution(n, computers));
    }
}

