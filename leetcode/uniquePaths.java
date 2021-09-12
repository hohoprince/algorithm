class Solution {
    
    public int uniquePaths(int m, int n) {
        
        int[][] pathCost = new int[m][n];
        
        for (int[] row : pathCost) {
            Arrays.fill(row, 1);
        }
        
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                pathCost[row][col] = pathCost[row - 1][col] + pathCost[row][col - 1];
            }
        }
        
        return pathCost[m - 1][n - 1];
        
    }
}
