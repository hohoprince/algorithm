class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                
                if (c == '.') continue;
                
                if (rows[row].contains(c)) return false;
                if (cols[col].contains(c)) return false;
                
                int boxIndex = (row / 3) * 3 + col / 3;
                if (boxes[boxIndex].contains(c)) return false;
                
                rows[row].add(c);
                cols[col].add(c);
                boxes[boxIndex].add(c);
                
            }
        }
        
        return true;
        
    }
}
