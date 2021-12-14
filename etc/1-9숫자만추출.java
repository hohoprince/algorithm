import java.util.*;

public class Main {

    public int solution(String str) {
        StringBuilder answer = new StringBuilder();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                answer.append(x);
            }
        }

        return Integer.parseInt(answer.toString());

//        풀이 1
//        int answer = 0;
//        for (char x : str.toCharArray()) {
//            if (x >= '0' && x <= '9') answer = answer * 10 + x - '0';
//        }
//
//        return answer;


//        내 풀이
//        return Integer.parseInt(str.replaceAll("[^0-9]", ""));
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
