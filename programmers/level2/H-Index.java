import java.util.*;

public class Main {

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int citation = citations[i];
            if (citations.length - i <= citation) {
                answer = Math.max(answer, citations.length - i);
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Main M = new Main();

        int[] citations = {3, 0, 6, 1, 5};

        System.out.println(M.solution(citations));
    }
}
