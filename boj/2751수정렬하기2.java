package main;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int num : arr) {
            sb.append(num).append('\n');
        }

        System.out.println(sb);
    }
}
