package main;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int count = 1;
        int prev = s.charAt(0) - '0';

        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (prev == num) continue;
            count++;
            prev = num;
        }

        System.out.println(count / 2);

    }
}

/*
0001100
 */
