class Solution {
    public int minPathSum(int[][] grid) {
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length;  col++) {
                
                if (row - 1 >= 0 && col - 1 >= 0) {
                    grid[row][col] = Math.min(grid[row - 1][col], grid[row][col - 1]) + grid[row][col];
                } else if (row - 1 < 0 && col -1 >= 0) {
                    grid[row][col] = grid[row][col] + grid[row][col - 1];
                } else if (row - 1 >= 0 && col - 1 < 0) {
                    grid[row][col] = grid[row][col] + grid[row - 1][col];
                }

            }
        }
        
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
