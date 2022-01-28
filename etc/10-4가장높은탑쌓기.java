import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Brick {
    int area;
    int height;
    int weight;

    public Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Brick{" +
                "area=" + area +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}

public class Main {

    int solution(int n, List<Brick> arr) {
        int[] maxHeights = new int[n];
        arr.sort((b1, b2) -> b2.area - b1.area);
        maxHeights[0] = arr.get(0).height;

        int answer = 0;

        for (int i = 1; i < n; i++) {
            Brick cur = arr.get(i);
            int maxHeight = cur.height;
            for (int j = 0; j < i; j++) {
                if (cur.weight < arr.get(j).weight) {
                    maxHeight = Math.max(maxHeight, maxHeights[j] + cur.height);
                }
            }
            maxHeights[i] = maxHeight;
            answer = Math.max(answer, maxHeight);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        List<Brick> arr = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int area = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            arr.add(new Brick(area, height, weight));
        }

        System.out.println(T.solution(n, arr));
    }
}
