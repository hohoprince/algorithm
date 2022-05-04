import java.util.*;

class Edge {
    int start;
    int dest;
    int cost;

    public Edge(int start, int dest, int cost) {
        this.start = start;
        this.dest = dest;
        this.cost = cost;
    }
}

public class Main {

    private int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));

        for (int[] c :  costs) {
            priorityQueue.add(new Edge(c[0], c[1], c[2]));
        }

        while (!priorityQueue.isEmpty()) {
            Edge poll = priorityQueue.poll();
            if (find(poll.start) != find(poll.dest)) {
                answer += poll.cost;
                union(poll.start, poll.dest);
            }
        }

        return answer;
    }

    private int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Main M = new Main();

        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        System.out.println(M.solution(n, costs));
    }
}

