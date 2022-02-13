import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class Main {

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};


    static int getMinDistance(Point startPoint, Point endPoint, int h, int w, char[][] room) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        queue.offer(startPoint);
        int count = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Point current = queue.poll();

                if (current.x == endPoint.x && current.y == endPoint.y) {
                    return count;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = current.x + dx[d];
                    int ny = current.y + dy[d];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && room[nx][ny] != 'x' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            count++;
        }
        return -1;
    }

    static void getPermutation(List<List<Integer>> permList, List<Integer> tmp,
                               List<Point> pointList, boolean[] visited) {
        if (tmp.size() == pointList.size()) {
            permList.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < pointList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(i + 1);
                getPermutation(permList, tmp, pointList, visited);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    static int solution(Point startPoint, List<Point> dustPoints, char[][] room, int h, int w) {
        List<List<Integer>> permList = new ArrayList<>();
        getPermutation(permList, new ArrayList<>(), dustPoints, new boolean[dustPoints.size()]);

        List<Point> allList = new ArrayList<>();
        allList.add(startPoint);
        allList.addAll(dustPoints);

        // 이동 경로 비용 그래프
        int[][] distance = new int[11][11];
        for (int i = 0; i < allList.size(); i++) {
            for (int j = 0; j < allList.size(); j++) {
                if (i != j && distance[i][j] == 0) {
                    int minDistance = getMinDistance(allList.get(i), allList.get(j), h, w, room);
                    if (minDistance == -1) {
                        return -1;
                    }
                    distance[i][j] = minDistance;
                    distance[j][i] = minDistance;
                }
            }
        }

        int minCost = Integer.MAX_VALUE;

        for (List<Integer> dustList : permList) {
            int sum = 0;
            for (int i = 0; i < dustList.size(); i++) {
                if (i == 0) {
                    sum += distance[0][dustList.get(i)];
                } else {
                    sum += distance[dustList.get(i - 1)][dustList.get(i)];
                }
            }
            minCost = Math.min(minCost, sum);
        }

        return minCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();

            if (w == 0 && h == 0) break;

            char[][] room = new char[h][w];
            List<Point> dustPoints = new ArrayList<>();
            Point startPoint = null;
            for (int i = 0; i < h; i++) {
                String s = sc.next();
                for (int j = 0; j < w; j++) {
                    char c = s.charAt(j);
                    if (c == '*') dustPoints.add(new Point(i, j));
                    if (c == 'o') startPoint = new Point(i, j);
                    room[i][j] = c;
                }
            }

         System.out.println(solution(startPoint, dustPoints, room, h, w));

        }
    }
}
