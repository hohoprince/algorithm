import java.util.*;

public class Main {

    static int solution(int n, int[] nums) {
        int[] counts = new int[nums.length];
        Arrays.fill(counts, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    counts[i] = Math.max(counts[i], counts[j] + 1);
                }
            }
        }

        int max = 0;
        for (int count : counts) {
            max = Math.max(count, max);
        }

        return max;
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
