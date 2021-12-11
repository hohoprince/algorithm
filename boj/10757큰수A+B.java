package main;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        StringBuilder sb = new StringBuilder(a);
        a = sb.reverse().toString();
        sb = new StringBuilder(b);
        b = sb.reverse().toString();

        sb = new StringBuilder();
        int index = 0;
        int carry = 0;
        int maxLength = Math.max(a.length(), b.length());

        for (int i = 0; i <= maxLength; i++) {
            int numA;
            int numB;
            if (a.length() <= index) {
                numA = 0;
            } else {
                numA = a.charAt(index) - '0';
            }
            if (b.length() <= index) {
                numB = 0;
            } else {
                numB = b.charAt(index) - '0';
            }

            int sum = numA + numB;

            if (i == maxLength && sum == 0 && carry == 0) {
                break;
            }
            sb.append((sum + carry) % 10);

            if (sum + carry > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            index++;
        }

        System.out.println(sb.reverse());

    }
}
