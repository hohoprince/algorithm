class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        for (int num : nums) treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        
        while (!treeMap.isEmpty()) {
            
            int count = 0;
            int key = treeMap.firstKey();
            
            while (count < k) {
                
                if (!treeMap.containsKey(key)) return false;
                int value = treeMap.get(key);
                
                if (value > 1) {
                    treeMap.put(key, value - 1);
                } else {
                    treeMap.remove(key);
                }
                
                count++;
                key++;
                
            }
            
        }
        
        return true;
        
    }
}
