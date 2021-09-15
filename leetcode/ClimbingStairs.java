class Solution {
    public int climbStairs(int n) {
        
        if (n == 1) return 1;
        
        int[] costs = new int[n + 1];
        
        costs[1] = 1;
        costs[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            costs[i] = costs[i - 1] + costs[i - 2];
        }
        
        return costs[n];
    }
}
