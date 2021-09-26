package main;


import java.util.*;

class Node implements Comparable<Node> {
    private int x;
    private int y;
    private int distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.distance, o.distance);
    }
}

public class Main {

    public static final int INF = (int) 1e9;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int r = 0; r < t; r++) {

            int n = sc.nextInt();

            int[][] field = new int[n][n];
            int[][] distances = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    field[i][j] = sc.nextInt();
                    distances[i][j] = INF;
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();

            pq.offer(new Node(0, 0, field[0][0]));
            distances[0][0] = field[0][0];

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                int x = node.getX();
                int y = node.getY();
                int distance = node.getDistance();

                if (distances[x][y] < distance) continue;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                    int cost = field[nx][ny] + distance;
                    if (distances[nx][ny] > cost) {
                        distances[nx][ny] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                }

            }

            System.out.println(distances[n - 1][n - 1]);

        }

    }

}

/*
1
3
5 5 4
3 9 1
3 2 7
 */
