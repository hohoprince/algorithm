class Solution {
    
    public static int[] dx;
    public int[] dy;
    public int numberOfArea;
    public int count;
    public int maxSizeOfOneArea;
    public boolean[][] visited;
    
    public void dfs(int x, int y, int[][] picture, int num, int m, int n) {
        count++;
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n
                    || picture[nx][ny] != num || visited[nx][ny]) continue;
            dfs(nx, ny, picture, num, m, n);
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        count = 0;
        maxSizeOfOneArea = 0;
        dx = new int[] {1, 0, -1, 0};
        dy = new int[] {0, 1, 0, -1};
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, picture, picture[i][j], m, n);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                    count = 0;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
