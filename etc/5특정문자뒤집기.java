import java.util.*;

public class Main {

    public String solution(String str) {
        String answer = "";
        char[] chs = str.toCharArray();

        int left = 0;
        int right = chs.length - 1;

        while (left < right) {
            char leftChar = chs[left];
            char rightChar = chs[right];

            if (!Character.isAlphabetic(leftChar)) {
                left++;
            } else if (!Character.isAlphabetic(rightChar)) {
                right--;
            } else {
                char tmp = chs[left];
                chs[left] = chs[right];
                chs[right] = tmp;
                left++;
                right--;
            }
        }

        answer = String.valueOf(chs);

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
