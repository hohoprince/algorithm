import java.util.*;

public class Main {

    public static String solution(String s, String pattern) {
        return  s.matches(pattern) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String pattern = "(100+1+|01)+";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(solution(sc.next(), pattern)).append('\n');
        }

        System.out.println(sb);
    }
}
