import java.util.*;

public class Main {

    public char solution(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                answer = key;
                max = map.get(key);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        System.out.println(T.solution(n, s));
    }
}
