import java.util.*;

public class Main {

    private static void checkParent(List<List<Integer>> graph, boolean[] visit, int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer adj : graph.get(poll)) {
                if (!visit[adj]) {
                    visit[adj] = true;
                    parent[adj] = poll;
                    queue.offer(adj);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean[] visit = new boolean[n + 1];
        int[] parent = new int[n + 1];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        checkParent(graph, visit, parent);

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }

    }
}
