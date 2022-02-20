import java.util.*;

public class Main {


    static int solution(String s) {
        int answer = 0;
        int num = 0;
        char operator = '+';

        for (char x : s.toCharArray()) {
            if (x == '+' || x == '-') {
                if (operator == '+') {
                    answer += num;
                } else {
                    answer -= num;
                }
                num = 0;
                if (x == '-') {
                    operator = '-';
                }
            } else {
                num = num * 10 + x - '0';
            }
        }

        if (operator == '+') {
            answer += num;
        } else {
            answer -= num;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(solution(s));
    }
}
