class Solution {
    
    private char[][] grid;
    
    private int[] rowOffsets = { 1, 0, -1, 0 };
    private int[] colOffsets = { 0, -1, 0, 1 };
    
    public int numIslands(char[][] grid) {
        
        this.grid = grid;
        
        int result = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(i, j)) result++;
            }
        }
        
        return result;
    }
    
    private boolean dfs(int row, int col) {
        
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return false;
        
        if (grid[row][col] == '0') return false;
        
        grid[row][col] = '0';
        
        for (int i = 0; i < 4; i++) {
            dfs(row + rowOffsets[i], col + colOffsets[i]);
        }
        
        return true;
        
    }
    
}
