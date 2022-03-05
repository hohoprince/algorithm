import java.util.*;

public class Main {

    static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);


        for (char x : s.toCharArray()) {
            if (Character.isAlphabetic(x)) {
                sb.append(x);
            } else if (x == '(') {
                stack.push(x);
            } else if (x == ')') {
                while (!stack.isEmpty()) {
                    char c = stack.pop();
                    if (c == '(') break;
                    sb.append(c);
                }
            } else { // +, -, *, /
                while (!stack.isEmpty() &&
                        map.get(stack.peek()) >= map.get(x)) {
                    sb.append(stack.pop());
                }
                stack.push(x);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        System.out.println(solution(s));
    }

}
