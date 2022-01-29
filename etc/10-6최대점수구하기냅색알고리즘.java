import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Problem {
    int score;
    int time;

    public Problem(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class Main {

    int solution(int n, int m, List<Problem> problems) {

        int[] maxScores = new int[m + 1];

        for (Problem problem : problems) {
            for (int i = m; i >= problem.time; i--) {
                if (maxScores[i - problem.time] + problem.score > maxScores[i]) {
                    maxScores[i] = maxScores[i - problem.time] + problem.score;
                }
            }
        }
        
        return maxScores[m];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Problem> problems = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            problems.add(new Problem(score, time));
        }

        System.out.println(T.solution(n, m, problems));
    }
}
