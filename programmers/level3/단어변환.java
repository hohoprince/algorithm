import java.util.*;

public class Main {

    int answer = Integer.MAX_VALUE;
    boolean[] visited;

    private void dfs(int start, int depth, String[] words, String target,
                     List<List<Integer>> graph) {
        if (start != words.length && words[start].equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }

        for (Integer adjNode : graph.get(start)) {
            if (!visited[adjNode]) {
                visited[adjNode] = true;
                dfs(adjNode, depth + 1, words, target, graph);
                visited[adjNode] = false;
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length + 1];

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < words.length + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isValid(words[i], words[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            if (isValid(words[i], begin)) {
                graph.get(i).add(words.length);
                graph.get(words.length).add(i);
            }
        }

        dfs(words.length, 0, words, target, graph);

        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }

        return answer;
    }

    private boolean isValid(String a, String b) {
        int count = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }

        return count <= 1;
    }

    public static void main(String[] args) {
        Main M = new Main();

        String begin = "hit";
        String target = "cog";

        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(M.solution(begin, target, words));
    }
}

