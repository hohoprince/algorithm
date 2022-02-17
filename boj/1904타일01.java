import java.util.Scanner;

public class Main {

    static long solution(int n) {
        int[] values = new int[1_000_001];
        values[1] = 1;
        values[2] = 2;

        for (int i = 3; i <= n; i++) {
            values[i] = (values[i - 1] + values[i - 2]) % 15746;
        }

        return values[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(solution(n));
    }
}
