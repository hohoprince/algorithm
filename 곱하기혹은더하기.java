package main;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        long result = s.charAt(0) - '0';

        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (result == 0 || result == 1 || num == 0 || num == 1) {
                result += num;
            } else {
                result *= num;
            }
        }

        System.out.println(result);

    }
}

/*
02984
 */
