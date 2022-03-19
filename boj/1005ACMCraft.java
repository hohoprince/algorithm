import java.util.*;

public class Main {

    private static int solution(int n, int[] time, int[] inDegree, List<List<Integer>> graph, int w) {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i] = time[i];
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            List<Integer> adjNodes = graph.get(cur);
            for (Integer x : adjNodes) {
                result[x] = Math.max(result[x], result[cur] + time[x]);
                inDegree[x]--;

                if (inDegree[x] == 0) {
                    queue.offer(x);
                }
            }
        }

        return result[w];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        List<Integer> answer = new ArrayList<>();

        for (int l = 0; l < t; l++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] time = new int[n + 1];
            int[] inDegree = new int[n + 1];

            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 1; i <= n; i++) {
                time[i] = sc.nextInt();
            }

            for (int i = 0; i < k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph.get(a).add(b);
                inDegree[b]++;
            }

            int w = sc.nextInt();

            answer.add(solution(n, time, inDegree, graph, w));
        }

        for (int x : answer) {
            System.out.println(x);
        }

    }
}

/*
2
4 4
10 1 100 10
1 2
1 3
2 4
3 4
4
8 8
10 20 1 5 8 7 1 43
1 2
1 3
2 4
2 5
3 6
5 7
6 7
7 8
7
 */
