import java.util.*;

public class Main {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] dis;

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int adjNode : graph.get(poll)) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    dis[adjNode] = dis[poll] + 1;
                    queue.offer(adjNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n + 1];
        dis = new int[n + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int destination = sc.nextInt();
            graph.get(start).add(destination);
        }

        T.bfs(1);

        for (int i = 2; i <= n ; i++) {
            System.out.println(i + " : " + dis[i]);
        }

    }
}

/*
// 입력
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

// 출력
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
 */
