import java.util.*;

class Problem {
    int score;
    int time;

    public Problem(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class Main {

    static int max = 0;

    public void dfs(int limit, int index, int scoreSum, int timeSum, Problem[] arr) {

        if (timeSum > limit) {
            return;
        }

        if (arr.length == index) {
            max = Math.max(max, scoreSum);
            return;
        }

        dfs(limit, index + 1, scoreSum + arr[index].score, timeSum + arr[index].time, arr);
        dfs(limit, index + 1, scoreSum, timeSum, arr);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Problem[] arr = new Problem[n];

        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            arr[i] = new Problem(score, time);
        }

        T.dfs(m, 0, 0, 0, arr);

        System.out.println(max);

    }
}

