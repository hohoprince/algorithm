import java.util.*;

public class Main {

    public int solution(int n, int[] arr) {
        int answer = 0;
        int currentScore = 1;

        for (int x : arr) {
            if (x == 1) {
                answer += currentScore;
                currentScore++;
            } else {
                currentScore = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
