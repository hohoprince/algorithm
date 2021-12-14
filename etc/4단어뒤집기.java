import java.util.*;

public class Main {

    public ArrayList<String> solution(int n, String[] strings) {
        ArrayList<String> answer = new ArrayList<>();

        for (String x : strings) {
            char[] s = x.toCharArray();
            int left = 0;
            int right = s.length - 1;

            while (left < right) {
                char tmp = s[left];
                s[left]  = s[right];
                s[right] = tmp;
                left++;
                right--;
            }
            answer.add(String.valueOf(s));
        }

//        1. StringBuilder 이용 문자열 뒤집기
//        for (String x : strings) {
//            String tmp = new StringBuilder(x).reverse().toString();
//            answer.add(tmp);
//        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = sc.next();
        }

        for (String x : T.solution(n, strings)) {
            System.out.println(x);
        }

    }
}
