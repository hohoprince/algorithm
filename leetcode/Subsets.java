class Solution {
    
    List<List<Integer>> output = new ArrayList();
    int n, k;
    
    private void backtrack(List<Integer> arr, int[] nums, int start) {
        
        if (arr.size() == k) {
            output.add(new ArrayList(arr));
            return;
        }
        
        for (int i = start; i < n; i++) {
            arr.add(nums[i]);
            backtrack(arr, nums, i + 1);
            arr.remove(arr.size() - 1);
        }
        
    }
    
    
    public List<List<Integer>> subsets(int[] nums) {
        
        n = nums.length;
        
        for (k = 0; k < n + 1; k++) {
            backtrack(new ArrayList<Integer>(), nums, 0);
        }
        
        return output;
    }
    
    
}
