class Solution {
    public int numTrees(int n) {
        
        int[] costs = new int[n + 1];
        costs[0] = 1;
        costs[1] = 1;
        
        for (int seq = 2; seq <= n; seq++) {
            int sumOfCost = 0;
            for (int rootNumber = 1; rootNumber <= seq; rootNumber++) {
                int leftCount = rootNumber - 1;
                int rightCount = seq - rootNumber;
                sumOfCost += costs[leftCount] * costs[rightCount];
            }
            costs[seq] = sumOfCost;
        }
        
        return costs[n];
        
    }
}
