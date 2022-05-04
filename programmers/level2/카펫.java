import java.util.*;

public class Main {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int rest = yellow / i;

                if ((i + 2) * (rest + 2) == brown + yellow) {
                    answer[0] = Math.max(i + 2, rest + 2);
                    answer[1] = Math.min(i + 2, rest + 2);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();

        int brown = 8;
        int yellow = 1;

        System.out.println(Arrays.toString(M.solution(brown, yellow)));
    }
}

