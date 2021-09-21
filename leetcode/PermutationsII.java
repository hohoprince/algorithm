class Solution {
    
    Set<List<Integer>> set = new HashSet<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<Integer> arr = new ArrayList<>();
        for (int n : nums) arr.add(n);
        
        backtrack(nums.length, 0, arr);
        
        return new ArrayList<>(set);
    }
    
    private void backtrack(int n, int index, List<Integer> arr) {
        
        if (index == n) {
            set.add(new ArrayList<Integer>(arr));
            return;
        }
        
        for (int i = index; i < n; i++) {
            Collections.swap(arr, i, index);
            backtrack(n, index + 1, arr);
            Collections.swap(arr, i, index);
        }
        
    }
}
