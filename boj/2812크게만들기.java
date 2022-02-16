import java.util.*;

public class Main {

    static String solution(int n, int k, String nums) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (char x : nums.toCharArray()) {
            int num = x - '0';

            if (deque.isEmpty()) {
                deque.offerLast(num);
            } else {
                while (!deque.isEmpty() && deque.peekLast() < num && k != 0) {
                    deque.pollLast();
                    k--;
                }
                deque.offerLast(num);
            }
        }

        if (k > 0) {
            for (int i = 0; i < k; i++) {
                deque.pollLast();
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String nums = sc.next();

        System.out.println(solution(n, k, nums));
    }
}
