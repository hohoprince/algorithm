
public class Test {

    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static String solution(int n) {
        String answer = "";
        String[] nums = { "4", "1", "2" };

        int p = n, q;
        while (p != 0) {
            q = p % 3;
            p = (p - 1) / 3;
            answer = nums[q] + answer;
        }
        return answer;
    }
}
