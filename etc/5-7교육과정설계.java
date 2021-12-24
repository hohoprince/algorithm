import java.util.*;

public class Main {

    public String solution(String s1, String s2) {
        Queue<Character> queue = new LinkedList<>();
        for (char x : s1.toCharArray()) {
            queue.offer(x);
        }
        for (char x : s2.toCharArray()) {
            if (queue.contains(x)) {
                char c = queue.poll();
                if (c != x) {
                    return "NO";
                }
            }
        }
        if (!queue.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(T.solution(s1, s2));
    }
}
