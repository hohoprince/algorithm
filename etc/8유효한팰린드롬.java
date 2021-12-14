import java.util.*;

public class Main {

    public String solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equals(tmp)) {
            answer = "YES";
        }

        return answer;


//        내 풀이
//        str = str.toLowerCase();
//
//        int left = 0;
//        int right = str.length() - 1;
//
//        while (left < right) {
//            if (!Character.isAlphabetic(str.charAt(left))) {
//                left++;
//            } else if (!Character.isAlphabetic(str.charAt(right))) {
//                right--;
//            } else {
//                if (str.charAt(left) != str.charAt(right)) {
//                    return "NO";
//                }
//                left++;
//                right--;
//            }
//        }
//
//        return "YES";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
