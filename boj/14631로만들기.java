import java.util.*;

public class Main {

    static int solution(int x) {
        int[] counts = new int[1_000_001];
        counts[1] = 0;
        counts[2] = 1;
        counts[3] = 1;

        for (int n = 4; n <= x; n++) {
            counts[n] = counts[n - 1] + 1;
            if (n % 3 == 0) counts[n] = Math.min(counts[n], counts[n / 3] + 1);
            if (n % 2 == 0) counts[n] = Math.min(counts[n], counts[n / 2] + 1);
        }

        return counts[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        System.out.println(solution(x));
    }
}
