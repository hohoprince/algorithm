class Solution {
    
    int rowSize;
    int colSize;
    
    int[] rowOffsets = { 0, 1, 0, -1 };
    int[] colOffsets = { 1, 0, -1, 0 };
    
    char[][] board;
    
    public boolean exist(char[][] board, String word) {
        
        rowSize = board.length;
        colSize = board[0].length;
        
        this.board = board;
        
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (backtrack(row, col, word, 0)) {
                    return true;
                }
            }
        }
     
        return false;
    }
    
    private boolean backtrack(int row, int col, String word, int index) {
        
        if (row >= rowSize || row < 0 || 
            col >= colSize || col < 0 || 
            board[row][col] != word.charAt(index)) {
            return false;
        }
        
        if (index == word.length() - 1) {
            return true;
        }
        
        board[row][col] = '#';
        
        for (int d = 0; d < 4; d++) {
            if (backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1)) {
                return true;
            };
        }
        
        board[row][col] = word.charAt(index);
        
        return false;
    }
}
