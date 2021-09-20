class Solution {
    
    int result = 0;
    boolean[] visited;
    
    public int countArrangement(int n) {
        
        visited = new boolean[n + 1];
        backtrack(n, 1);
        
        return result;
        
    }
    
    private void backtrack(int n, int value) {
        
        if (value > n) result++;
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (value % i == 0 || i % value == 0)) {
                
                visited[i] = true;
                backtrack(n, value + 1);
                visited[i] = false;
                
            }
        }
        
    }
}
