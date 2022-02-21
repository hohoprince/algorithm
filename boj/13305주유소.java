import java.util.*;

public class Main {

    static long solution(int n, int[] distance, int[] price) {
        int minPrice = Integer.MAX_VALUE;
        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            minPrice = Math.min(minPrice, price[i]);
            answer += (long) minPrice * distance[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] distance = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distance[i] = sc.nextInt();
        }

        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        System.out.println(solution(n, distance, price));

    }
}
