import java.util.*;

public class Main {

    public String solution(String str) {
        StringBuilder answer = new StringBuilder();

        str = str + " ";

        int cnt = 1;
        for (int i = 0; i < str.length() - 1; i++) {
             if (str.charAt(i) == str.charAt(i + 1)) cnt++;
             else {
                 answer.append(str.charAt(i));
                 if (cnt > 1) answer.append(cnt);
                 cnt = 1;
             }
        }

        return answer.toString();


//        내 풀이
//        char ch = str.charAt(0);
//        int count = 0;
//
//        for (char x : str.toCharArray()) {
//            if (x == ch) {
//                count++;
//            } else {
//                answer.append(ch);
//                if (count != 1) {
//                    answer.append(count);
//                }
//                ch = x;
//                count = 1;
//            }
//        }
//
//        answer.append(ch);
//        if (count != 1) {
//            answer.append(count);
//        }
//
//        return answer.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
