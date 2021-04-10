import java.io.IOException;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 2, 3 })));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Arrays.fill(answer, 0);
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    answer[i]++;
                } else {
                    answer[i]++;
                    break;
                }
            }
        }
        return answer;
    }
}
