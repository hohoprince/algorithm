class Solution {
    
    boolean[][] visited;
    
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        visited = new boolean[maze.length][maze[0].length];
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        
        
        dfs(start[0], start[1], maze);
        
        return visited[destination[0]][destination[1]];
        
    }
    
    private void dfs(int row, int col, int[][] maze) {
        
        if (visited[row][col]) return;
        
        visited[row][col] = true;
        
        // 왼쪽
        int left = col;
        while (left - 1 >= 0 && maze[row][left - 1] == 0) {
            left--;
        }
        dfs(row, left, maze);
        
        // 오른쪽
        int right = col;
        while (right + 1 < maze[0].length && maze[row][right + 1] == 0) {
            right++;
        }
        dfs(row, right, maze);
        
        // 위
        int up = row;
        while (up - 1 >= 0 && maze[up - 1][col] == 0) {
            up--;
        }
        dfs(up, col, maze);
        
        // 아래
        int down = row;
        while (down + 1 < maze.length && maze[down + 1][col] == 0) {
            down++;
        }
        dfs(down, col, maze);
    }
}
