class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 1) return nums[0];
        
        int[] moneys = new int[nums.length];
        
        moneys[0] = nums[0];
        moneys[1] = Math.max(nums[1], nums[0]);
        
        
        for (int i = 2; i < moneys.length; i++) {
            moneys[i] = Math.max(moneys[i - 2] + nums[i], moneys[i - 1]);
        }
        
        return moneys[moneys.length - 1];
    }
}
