import java.util.Scanner;

public class Main {

    static int[] zeros = new int[41];
    static int[] ones = new int[41];

    static void solution(int number) {
        zeros[number] = zeros[number - 1] + zeros[number - 2];
        ones[number] = ones[number - 1] + ones[number - 2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] nums = new int[t];

        zeros[0] = 1;
        ones[1] = 1;

        for (int i = 0; i < t; i++) {
            nums[i] = sc.nextInt();
        }

        for (int x : nums) {
            for (int i = 2; i <= x; i++) {
                solution(i);
            }
        }

        for (int x: nums) {
            System.out.println(zeros[x] + " " + ones[x]);
        }
    }
}
