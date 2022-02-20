import java.util.*;

public class Main {


    static int solution(int n, int[] arr) {
        int[] sums = new int[n];

        sums[0] = arr[0];
        int answer = arr[0];

        for (int i = 1; i < n; i++) {
            if (sums[i - 1] > 0) {
                sums[i] = sums[i - 1] + arr[i];
            } else {
                sums[i] = arr[i];
            }

            answer = Math.max(answer, sums[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, arr));
    }
}
