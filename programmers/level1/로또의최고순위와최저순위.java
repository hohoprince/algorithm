import java.util.*;

public class Main {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int count1 = 0; // 맞은 개수
        int count2 = 0; // 0 개수

        Set<Integer> set = new HashSet<>();

        for (int x : win_nums) {
            set.add(x);
        }

        for (int x : lottos) {
            if (x == 0) {
                count2++;
            } else if (set.contains(x)) {
                count1++;
            }
        }

        answer[1] = getRank(count1);
        count1 += count2;
        answer[0] = getRank(count1);

        return answer;
    }

    private int getRank(int count) {
        if (count >= 2) return 7 - count;
        return 6;
    }

    public static void main(String[] args) {
        Main M = new Main();

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        System.out.println(Arrays.toString(M.solution(lottos, win_nums)));
    }
}

