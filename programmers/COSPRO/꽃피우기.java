// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    
    class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
    
    public int solution(int[][] garden) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        
        Queue<Point> queue = new LinkedList<>();
        
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[0].length; j++) {
                if (garden[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        
        while (!queue.isEmpty()) {
            answer++;
            
            int queueSize = queue.size();
            
            for (int i = 0; i < queueSize; i++) {
                Point cur = queue.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    
                    if (nx >= 0 && nx < garden.length
                        && ny >= 0 && ny < garden[0].length && garden[nx][ny] == 0) {
                        garden[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
        
        return answer - 1;
    }
    
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(garden1);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
        
        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(garden2);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
        
    }    
}
