class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        int maxLength = 0;
        int start = 0;
        int end = 0;
        
        
        while (end < s.length()) {
            char endChar = s.charAt(end);
            map.put(endChar, end++);

            if (map.size() > k) {
                int minIndex = Collections.min(map.values());
                map.remove(s.charAt(minIndex));
                start = minIndex + 1;
            }
            maxLength = Math.max(maxLength, end - start);
        }
            
        
        
        return maxLength;
        
    }
}
