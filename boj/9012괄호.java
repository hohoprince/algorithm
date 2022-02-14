import java.util.*;

public class Main {

    static String solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (!stack.isEmpty() && stack.pop() == '(') {
                    continue;
                } else {
                    return "NO";
                }
            }
        }

        if (!stack.isEmpty()) {
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<String> answers = new ArrayList<>();
        List<String> inputs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            inputs.add(sc.next());
        }

        for (int i = 0; i < n; i++) {
            answers.add(solution(inputs.get(i)));
        }

        for (String x : answers) {
            System.out.println(x);
        }
    }
}
