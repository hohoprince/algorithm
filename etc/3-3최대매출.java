import java.util.*;

public class Main {

    public int solution(int n, int k, int[] arr) {
        int start = 0;
        int end = k;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int answer = sum;

        while (end < n) {
            sum += arr[end++] - arr[start++];
            answer = Math.max(sum, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }
}
