class Solution {
    
    int[] rowOffsets = { -1, 0, 1, 0 };
    int[] colOffsets = { 0, 1, 0, -1 };
    int rowSize;
    int colSize;
    int[][] grid;
    boolean isClosed = true;
    
    private boolean backtrack(int row, int col) {
        
        if (row < 0 || row > rowSize - 1 || col < 0 || col > colSize - 1) {
            return false;
        }
        if (grid[row][col] == 0) {   
            if (row == 0 || col == 0 || row == rowSize - 1 || col == colSize - 1) {
                isClosed = false;
            }
            
            grid[row][col] = 1;   
            
            for (int d = 0; d < 4; d++) {
                backtrack(row + rowOffsets[d], col + colOffsets[d]);
            }
            
            return true;
        }
        return false;
    }
    
    public int closedIsland(int[][] grid) {
        int answer = 0;
        this.grid = grid;
        
        rowSize = grid.length;
        colSize = grid[0].length;
        
        for (int i = 1; i < rowSize - 1; i++) {
            for (int j = 1; j < colSize - 1; j++) {
                if (grid[i][j] == 0) {
                    isClosed = true;
                    if (backtrack(i, j)) {
                        if (isClosed) {
                            answer++;       
                        }
                    }
                }
            }
        }
        
        return answer;
        
    }
}
