import java.util.Scanner;

public class Main {
    static long[] values = new long[101];

    static long solution(int n) {
        values[1] = 1;
        values[2] = 1;
        values[3] = 1;
        values[4] = 2;
        values[5] = 2;

        for (int i = 6; i <= n; i++) {
            values[i] = values[i - 1] + values[i - 5];
        }

        return values[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = solution(sc.nextInt());
        }

        for (long x : answer) {
            System.out.println(x);
        }
    }
}
