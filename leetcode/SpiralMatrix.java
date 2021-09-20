class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        int[] rowOffsets = { 0, 1, 0, -1 };
        int[] colOffsets = { 1, 0, -1, 0 };
        int index = 0;
        int row = 0;
        int col = 0;
        
        while (true) {
            
            result.add(matrix[row][col]);
            visited[row][col] = true;
            
            int nextRow = row + rowOffsets[index];
            int nextCol = col + colOffsets[index];
            
            if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length 
                || visited[nextRow][nextCol]) {
                index = (index + 1) % 4;
                nextRow = row + rowOffsets[index];
                nextCol = col + colOffsets[index];
                if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length 
                || visited[nextRow][nextCol]) {
                    break;
                }
            }
            
            row = nextRow;
            col = nextCol;
            
        }
        
        return result;
        
    }
}
