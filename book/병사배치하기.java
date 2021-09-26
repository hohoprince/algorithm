package main;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();
        int[] counts = new int[n];
        Arrays.fill(counts, 1);

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        Collections.reverse(arr);

        for (int i = 1; i < arr.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) < arr.get(i)) {
                    counts[i] = Math.max(counts[i], counts[j] + 1);
                }
            }
        }

        int maxValue = 0;
        for (int count : counts) {
            maxValue = Math.max(maxValue, count);
        }

        System.out.println(n - maxValue);

    }

}

/*
7
15 11 4 8 5 2 4
 */
