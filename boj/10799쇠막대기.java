import java.util.*;

public class Main {

    static int solution(String s) {
        int size = 0;
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (s.charAt(i + 1) == ')') { // 자르기
                    answer += size;
                    i++;
                } else {
                    size++;
                }
            } else { // ')'
                answer++;
                size--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(solution(s));
    }
}
