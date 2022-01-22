import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n;
    static int m;
    static List<Point> houses;
    static List<Point> pizzas;
    static List<List<Point>> combination;
    static LinkedList<Point> temp;
    static int answer = Integer.MAX_VALUE;

    public void dfs(int start, int length) {
        if (length == m) {
            combination.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < pizzas.size(); i++) {
            temp.add(pizzas.get(i));
            dfs(i + 1, length + 1);
            temp.removeLast();
        }
    }

    public int getDistance(List<Point> selected) {
        int sum = 0;
        for (Point house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (Point pizza : selected) {
                minDistance = Math.min(minDistance,
                        Math.abs(house.x - pizza.x) + Math.abs(house.y - pizza.y));
            }
            sum += minDistance;
        }

        return sum;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        houses = new ArrayList<>();
        pizzas = new ArrayList<>();
        combination = new ArrayList<>();
        temp = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                if (num == 1) houses.add(new Point(i, j));
                else if (num == 2) pizzas.add(new Point(i, j));
            }
        }

        T.dfs(0, 0);

        for (List<Point> selected : combination) {
            int distance = T.getDistance(selected);
            answer = Math.min(answer, distance);
        }

        System.out.println(answer);

    }
}

