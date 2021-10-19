import java.util.*;

class Solution {
    
    public List<String> makeWordsList(String str) {
        List<String> wordList = new ArrayList<>();

        for (int i = 1, j = 0; i < str.length(); i++) {
            String sub = str.substring(j, i + 1);
            if (Character.isLetter(sub.charAt(0)) 
                && Character.isLetter(sub.charAt(1))) {
                wordList.add(sub);
            }
            j++;
        }

        return wordList;
    }
    
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> arr1 = makeWordsList(str1);
        List<String> arr2 = makeWordsList(str2);

        if (arr1.isEmpty() && arr2.isEmpty()) return 65536;
        
        Map<String, Integer> map = new HashMap<>();

        for (String word : arr1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int count = 0;

        for (String word : arr2) {
            if (map.containsKey(word) && map.get(word) > 0) {
                count++;
                map.put(word, map.getOrDefault(word, 0) - 1);
            }
        }

        int result = (int) Math.floor(
            ((double) count / (arr1.size() + arr2.size() - count)) * 65536);
        
        return result;
    }
}
