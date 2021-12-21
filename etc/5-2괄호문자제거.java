import java.util.*;

public class Main {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else if (x == ')') {
                stack.pop();
            } else {
                if (stack.isEmpty()) sb.append(x);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(T.solution(s));
    }
}
