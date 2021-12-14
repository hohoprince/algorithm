import java.util.*;

public class Main {

    public int[] solution(String str, char ch) {
        int[] answer = new int[str.length()];
        int count = 1000;

        for (int i = 0; i < answer.length; i++) {
            if (str.charAt(i) == ch) count = 0;
            else count++;
            answer[i] = count;
        }

        count = 1000;
        for (int i = answer.length - 1; i >= 0; i--) {
            if (str.charAt(i) == ch) {
                count = 0;
            } else {
                count++;
                answer[i] = Math.min(count, answer[i]);
            }
        }

        return answer;

//        내 풀이
//        ArrayList<Integer> answer = new ArrayList<>();
//        ArrayList<Integer> indexes = new ArrayList<>();
//
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ch) {
//                indexes.add(i);
//            }
//        }
//
//        for (int i = 0; i < str.length(); i++) {
//            int min = Integer.MAX_VALUE;
//            for (int index : indexes) {
//                min = Math.min(Math.abs(index - i), min);
//            }
//            answer.add(min);
//        }
//
//        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char ch = sc.next().charAt(0);

        for (int dis : T.solution(str, ch)) {
            System.out.print(dis + " ");
        }
    }
}
