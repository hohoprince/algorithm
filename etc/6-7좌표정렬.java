import java.util.*;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

public class Main {

    public void solution(int n, List<Point> points) {
        points.sort((p1, p2) -> {
            if (p1.getX() == p2.getX()) {
                return Integer.compare(p1.getY(), p2.getY());
            } else {
                return Integer.compare(p1.getX(), p2.getX());
            }
        });
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(x, y));
        }

        T.solution(n, points);

        for (Point x : points) {
            System.out.println(x);
        }

    }
}
