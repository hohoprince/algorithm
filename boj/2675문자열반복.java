package main;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            for (char c : s.toCharArray()) {
                for (int j = 0; j < n; j++) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }

    }
}
