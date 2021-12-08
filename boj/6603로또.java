package main;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            List<List<Integer>> answers = new ArrayList<>();
            LinkedList<Integer> temp = new LinkedList<>();

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            backtrack(answers, temp, nums, 0);

            for (int k = 0; k < answers.size(); k++) {
                for (int i = 0; i < answers.get(k).size(); i++) {
                    System.out.print(answers.get(k).get(i));
                    if (i != answers.get(k).size() - 1) System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();

        }

    }

    private static void backtrack(List<List<Integer>> answers, LinkedList<Integer> li,
                                  int[] nums, int index) {
        if (li.size() == 6) {
            answers.add(new ArrayList<>(li));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            li.add(nums[i]);
            backtrack(answers, li, nums, i + 1);
            li.removeLast();
        }
    }

}
