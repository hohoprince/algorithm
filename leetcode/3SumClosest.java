class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int result = 0;
        int min = Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = target - sum;
                int absDiff = Math.abs(diff);

                if (absDiff < min) {
                    result = sum;
                    min = absDiff;
                }

                if (diff < 0) {
                    right--;
                } else {
                    left++;
                }
            }
                
        }
        
        return result;
    }
}
