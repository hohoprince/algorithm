import java.util.*;

public class Main {

    static boolean[] visited;

    static int bfs(int[] upDown, int curFloor, int f, int g) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(curFloor);

        int count = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int cur = queue.poll();

                if (cur == g) {
                    return count;
                }

                for (int x : upDown) {
                    if (x == 0) continue;

                    int destination = cur + x;
                    if (destination <= f && destination > 0 && !visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            count++;
        }

        return -1;
    }

    static int solution(int f, int s, int g, int u, int d) {
        int[] upDown = new int[2];
        upDown[0] = u;
        upDown[1] = -d;

        return bfs(upDown, s, f, g);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int f = sc.nextInt(); // 전체 층
        int s = sc.nextInt(); // 현재 층
        int g = sc.nextInt(); // 스타트링크 층
        int u = sc.nextInt(); // u 버튼
        int d = sc.nextInt(); // d 버튼

        visited = new boolean[f + 1];

        int answer = solution(f, s, g, u ,d);

        System.out.println(answer == -1 ? "use the stairs" : answer);

    }
}
