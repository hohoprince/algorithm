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

        List<Integer> arr2 = new ArrayList<>(arr);
        Collections.sort(arr2);

        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int num : arr2) {
            if (!map.containsKey(num)) {
                map.put(num, index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb);
    }
}
