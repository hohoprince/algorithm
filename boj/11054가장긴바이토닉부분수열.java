import java.util.*;

public class Main {

    static int solution(int n, int[] nums) {
        int[] counts = new int[n];
        int[] reverseCounts = new int[n];

        Arrays.fill(counts, 1);
        Arrays.fill(reverseCounts, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    counts[i] = Math.max(counts[i], counts[j] + 1);
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    reverseCounts[i] = Math.max(reverseCounts[i], reverseCounts[j] + 1);
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, counts[i] + reverseCounts[i] - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(solution(n, nums));
    }
}
