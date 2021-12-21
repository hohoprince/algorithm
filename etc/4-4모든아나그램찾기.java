import java.util.*;

public class Main {

    public int solution(String s1, String s2) {
        int answer = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char x : s2.toCharArray()) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < s2.length() - 1; i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int start = 0;
        for (int end = s2.length() - 1; end < s1.length(); end++) {
            map1.put(s1.charAt(end), map1.getOrDefault(s1.charAt(end), 0) + 1);
            if (map1.equals(map2)) answer++;
            if (map1.get(s1.charAt(start)) - 1 == 0) {
                map1.remove(s1.charAt(start));
            } else {
                map1.put(s1.charAt(start), map1.get(s1.charAt(start)) - 1);
            }

            start++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(T.solution(s1, s2));
    }
}
