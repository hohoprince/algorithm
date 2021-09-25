package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static List<List<String>> arr = new ArrayList<>();
    public static List<List<String>> reversedArr = new ArrayList<>();


    public static int lowerBound(List<String> arr, String target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr.get(mid).compareTo(target) >= 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int upperBound(List<String> arr, String target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr.get(mid).compareTo(target) > 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int countByRange(List<String> arr, String leftValue, String rightValue) {
        int rightIndex = upperBound(arr, rightValue, 0, arr.size());
        int leftIndex = lowerBound(arr, leftValue, 0, arr.size());
        return rightIndex - leftIndex;
    }

    public static void main(String[] args) {

        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] result = new int[queries.length];

        for (int i = 0; i < 10001; i++) {
            arr.add(new ArrayList<>());
            reversedArr.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            arr.get(word.length()).add(word);
            word = (new StringBuffer(word)).reverse().toString();
            reversedArr.get(word.length()).add(word);
        }

        for (int i = 0; i < 10001; i++) {
            Collections.sort(arr.get(i));
            Collections.sort(reversedArr.get(i));
        }

        for (int i = 0; i < queries.length; i++) {
            int res;
            String query = queries[i];
            if (query.charAt(0) != '?') {
                res = countByRange(arr.get(query.length()), query.replaceAll("\\?", "a"),
                        query.replaceAll("\\?", "z"));
            } else {
                query = (new StringBuffer(query)).reverse().toString();
                res = countByRange(reversedArr.get(query.length()), query.replaceAll("\\?", "a"),
                        query.replaceAll("\\?", "z"));
            }

            result[i] = res;

        }

        System.out.println(Arrays.toString(result));

    }

}
