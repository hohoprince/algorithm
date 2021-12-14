import java.util.*;

public class Main {

    public String solution(String str) {
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equalsIgnoreCase(tmp)) {
            answer = "YES";
        }
        return answer;

//        첫 번째 풀이
//        int len = str.length();
//        str = str.toLowerCase();
//        for (int i = 0; i < len / 2; i++) {
//            if (str.charAt(i) != str.charAt(len - 1 - i)) {
//                return "NO";
//            }
//        }
//
//        return "YES";

//        내 풀이
//        str = str.toLowerCase();
//
//        int left = 0;
//        int right = str.length() - 1;
//
//        while (left < right) {
//            if (str.charAt(left++) != str.charAt(right--)) {
//                return "NO";
//            }
//        }
//        return "YES";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
