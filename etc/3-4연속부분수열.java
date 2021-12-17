import java.util.*;

public class Main {

    public int solution(int n, int m, int[] arr) {
        int start = 0;
        int sum = 0;
        int answer = 0;

        for (int end = 0; end < n; end++) {
            sum += arr[end];
            if (sum == m) answer++;

            while (sum >= m) {
                sum -= arr[start++];
                if (sum == m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
