class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (num1, num2) -> map.get(num1) - map.get(num2)
        );
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) pq.poll();
        }
        
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }
        
        return result;
        
    }
}
