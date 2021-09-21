class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) numsList.add(num);
        
        backtrack(nums.length, numsList, 0);
        
        return result;
        
    }
    
    private void backtrack(int length, List<Integer> nums, int start) {
        if (start == length) result.add(new ArrayList<Integer>(nums));
        
        for (int i = start; i < length; i++) {
            Collections.swap(nums, start, i);
            backtrack(length, nums, start + 1);
            Collections.swap(nums, start, i);
        }
    }
}
