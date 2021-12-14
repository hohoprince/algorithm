import java.util.*;

public class Main {

    public String solution(int num, String str) {
        StringBuilder answer = new StringBuilder();
        str = str.replace('#', '1').replace('*', '0');
        for (int i = 0; i < num; i++) {
            String tmp = str.substring(0, 7);
            int n = Integer.parseInt(tmp, 2);
            answer.append((char) n);
            str = str.substring(7);
        }

        return answer.toString();

//        내 풀이
//        StringBuilder answer = new StringBuilder();
//        int len = str.length() / num;
//
//        for (int i = 0; i < num; i++) {
//            String sub = str.substring(i * len, (i + 1) * len);
//            int n = 0;
//            for (char c : sub.toCharArray()) {
//                if (c == '*') n = n * 2;
//                else n = n * 2 + 1;
//            }
//            answer.append((char) n);
//        }
//
//        return answer.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = sc.next();

        System.out.println(T.solution(num, str));
    }
}
