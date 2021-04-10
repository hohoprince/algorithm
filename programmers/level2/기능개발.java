import java.util.*;

public class Test {

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 99, 99, 99, 98 }, new int[] { 1, 1, 1, 1 }));
    }

    public static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        int startIndex = 0;

        while (startIndex != progresses.length) {
            for (int i = startIndex; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            int count = 0;
            for (int i = startIndex; i < progresses.length; i++) {
                if (progresses[i] >= 100) {
                    count++;
                } else {
                    break;
                }
            }

            if (count > 0) {
                answer.add(count);
                startIndex += count;
            }
        }
        return answer;
    }
}

