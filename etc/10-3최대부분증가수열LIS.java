import java.util.Scanner;

public class Main {

    int solution(int n, int[] arr, int[] values) {
        int answer = 0;
        values[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, values[j]);
                }
            }
            values[i] = max + 1;
            answer = Math.max(max + 1, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, arr, values));
    }
}
