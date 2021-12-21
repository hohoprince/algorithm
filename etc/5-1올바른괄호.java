import java.util.*;

public class Main {

    public String solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(T.solution(s));
    }
}
