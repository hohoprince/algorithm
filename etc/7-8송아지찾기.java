import org.w3c.dom.Node;

import java.util.*;

public class Main {

    int[] dx = {-1, 1, 5};
    Queue<Integer> q = new LinkedList<>();
    boolean[] check;

    public void bfs(int s, int e) {
        int level = 0;
        check = new boolean[10001];

        q.offer(s);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.poll();
                if (check[x]) {
                    continue;
                }
                check[x] = true;
                if (x == e) {
                    System.out.println(level);
                    return;
                }

                for (int j = 0; j < 3; j++) {
                    int nx = x + dx[j];
                    if (nx >= 1 && nx <= 10000) {
                        q.offer(x + dx[j]);
                    }
                }
            }
            level++;
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();

        T.bfs(s, e);
    }
}
