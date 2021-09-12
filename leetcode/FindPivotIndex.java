class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        int leftSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (total - nums[i] - leftSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        
        return -1;
    }
}
