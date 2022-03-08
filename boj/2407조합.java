import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static String[][] save;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        save = new String[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(save[i], "0");
        }

        System.out.println(combination(n, m));
    }

    private static String addStringNumber(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        StringBuilder sb = new StringBuilder();

        String longerNum;
        int maxLength;
        int minLength;

        if (a.length() > b.length()) {
            longerNum = a;
            maxLength = a.length();
            minLength = b.length();
        } else {
            longerNum = b;
            maxLength = b.length();
            minLength = a.length();
        }


        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int sum;
            if (i < minLength) {
                sum = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;
            } else {
                sum = longerNum.charAt(i) - '0' + carry;
            }
            if (sum > 9) {
                carry = 1;
                sb.append(sum - 10);
            } else {
                carry = 0;
                sb.append(sum);
            }
        }

        if (carry == 1) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    private static String combination(int n, int m) {
        if (n == m || m == 0) {
            return "1";
        }

        if (save[n][m] != "0") {
            return save[n][m];
        }

        return save[n][m] = addStringNumber(combination(n - 1, m - 1),
                combination(n - 1, m));
    }
}

