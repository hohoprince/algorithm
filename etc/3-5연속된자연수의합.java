import java.util.*;

public class Main {

    public int solution(int n) {
        int answer = 0;
        int start = 1;
        int sum = 0;

        for (int end = 1; end <= n / 2 + 1; end++) {
            sum += end;
            if (sum == n) answer++;

            while (sum >= n) {
                sum -= start++;
                if (sum == n) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}
