import java.util.Scanner;

public class Main {

    public String solution(String str) {
        String answer = "";

        int min = Integer.MIN_VALUE, pos;

        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > min) {
                min = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }

        if (str.length() > min) answer = str;

        return answer;

//        String[] s = str.split(" ");
//        for (String x : s) {
//            int len = x.length();
//            if (len > min) {
//                min = len;
//                answer = x;
//            }
//        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(T.solution(str));

    }
}
