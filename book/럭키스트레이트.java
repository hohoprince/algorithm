package main;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int sum = 0;

        for (int i = 0; i < s.length() / 2; i++) {
             sum += s.charAt(i) - '0';
        }

        for (int i = s.length() / 2; i < s.length(); i++) {
            sum -= s.charAt(i) - '0';
        }

        if (sum == 0) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }

    }
}

/*
123402

7755
 */
