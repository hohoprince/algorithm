class Solution {
    public int maxSubArray(int[] nums) {
        
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        while (end < nums.length) {
         
            sum += nums[end];
            
            max = Math.max(max, sum);
            
            if (sum <= 0) {
                start = end + 1;
                end = end + 1;
                sum = 0;
            } else {
                end++;
            }
            
        }
        
        return max;
        
    }
}
