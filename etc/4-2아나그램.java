import java.util.*;

public class Main {

    public String solution(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) return "NO";
            map.put(c, map.getOrDefault(c, 0) - 1);
        }


        return answer;

//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (char c : s1.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//
//        for (char c : s2.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) - 1);
//        }
//
//        for (int x : map.values()) {
//            if (x != 0) {
//                return "NO";
//            }
//        }
//
//        return "YES";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(T.solution(s1, s2));
    }
}
