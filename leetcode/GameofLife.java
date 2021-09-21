class Solution {
    
    int[] rowOffsets = { -1, -1, -1, 0, 1, 1, 1, 0 };
    int[] colOffsets = { -1, 0, 1, 1, 1, 0, -1, -1 };
    
    int[][] board;
    int[][] copyBoard;
    
    public void gameOfLife(int[][] board) {
        
        this.board = board;
        copyBoard = new int[board.length][];
        
        for (int i = 0; i < board.length; i++) {
            copyBoard[i] = board[i].clone();
        }
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                
                int num = copyBoard[row][col];
                
                if (num == 0) {
                    if (getOneCount(row, col) == 3) {
                        board[row][col] = 1;    
                    }
                } else {
                    int count = getOneCount(row, col);
                    if (count < 2 || count > 3) {
                        board[row][col] = 0;
                    }
                }
                
            }
        }
        
    }
    
    private int getOneCount(int row, int col) {
        
        int count = 0;
        
        for (int i = 0; i < rowOffsets.length; i++) {
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) continue;
            if (copyBoard[newRow][newCol] == 1) {
                count++;
            }   
        }
        return count;
        
    }
}
