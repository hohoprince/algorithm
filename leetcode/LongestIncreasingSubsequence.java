class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] counts = new int[nums.length];
        Arrays.fill(counts, 1);
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    counts[i] = Math.max(counts[i], counts[j] + 1);
                }
            }
        }
        
        int max = 0;
        for (int count : counts) {
            max = Math.max(count, max);
        }
        
        return max;
        
    }
}
