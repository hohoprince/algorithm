class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String sortedString = new String(chs);
            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(s);
            } else {
                ArrayList<String> li = new ArrayList<>();
                li.add(s);
                map.put(sortedString, li);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        
        for (String s : map.keySet()) {
            result.add(map.get(s));
        }
        
        return result;
    }
}
