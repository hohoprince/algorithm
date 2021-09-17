class Solution {
    
    private List<List<Integer>> result;
    private int[] candidates;
    private LinkedList<Integer> elements;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        this.elements = new LinkedList<>();
        this.candidates =  candidates;
        
        backtrack(0, target, 0);
        
        return result;
    }
    
    private void backtrack(int sum, int target, int index) {
        
        if (sum == target) {
            result.add(new ArrayList(elements));
            return;
        }
        
        if (sum > target) return;
        
        for (int i = index; i < candidates.length; i++) {
            elements.add(candidates[i]);
            backtrack(sum + candidates[i], target, i);
            elements.removeLast();
        }
        
    }
    
}
