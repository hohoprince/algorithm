import java.util.*;

public class Main {

    public int solution(String s) {

        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int n1 = stack.pop();
                int n2 = stack.pop();
                if (c == '+') {
                    stack.push(n2 + n1);
                } else if (c == '*') {
                    stack.push(n2 * n1);
                } else if (c == '-') {
                    stack.push(n2 - n1);
                } else if (c == '/') {
                    stack.push(n2 / n1);
                }
            }
        }

        return stack.pop();

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(T.solution(s));
    }
}
