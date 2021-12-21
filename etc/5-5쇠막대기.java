import java.util.*;

public class Main {

    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == '(') {
                if (s.charAt(i + 1) == ')') { // 레이저인 경우
                    answer += stack.size();
                    i++;
                } else { // 레이저가 아닌 경우
                    stack.push(x);
                }
            } else { // 닫는 괄호인 경우 현재 막대의 개수를 하나 없애고 조각 하나 증가
                stack.pop();
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(T.solution(s));
    }
}
