import java.util.Scanner;
import java.util.Stack;

public class Main {

    static String solution(String str, String target) {
        Stack<Character> stack = new Stack<>();
        final int TARGET_SIZE = target.length();

        for (char x : str.toCharArray()) {
            stack.push(x);
            if (stack.size() >= TARGET_SIZE) {
                int stackSize = stack.size();
                char[] chars = new char[TARGET_SIZE];
                for (int i = 0; i < TARGET_SIZE; i++) {
                    chars[i] = stack.get(stackSize - TARGET_SIZE + i);
                }
                if (String.valueOf(chars).equals(target)) {
                    for (int i = 0; i < TARGET_SIZE; i++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String target = sc.next();
        String answer = solution(str, target);
        System.out.println(answer.equals("") ? "FRULA" : answer);

    }
}
