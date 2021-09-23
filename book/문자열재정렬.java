package main;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        List<Character> list = new ArrayList<>();
        int sum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                list.add(c);
            } else {
                sum += c - '0';
            }
        }

        Collections.sort(list);

        for (Character c : list) {
            System.out.print(c);
        }

        if (sum != 0) System.out.println(sum);

    }
}

/*
ex 1
K1KA5CB7

ex 2
AJKDLSI412K4JSJ9D
 */
