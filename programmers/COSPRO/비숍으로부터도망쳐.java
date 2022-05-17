// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    public int solution(String[] bishops) {
        int answer = 0;
			
			boolean[][] check = new boolean[8][8];
			
			int[] dx = {1, 1, -1, -1};
			int[] dy = {-1, 1, -1, 1};
				
			for (int i = 0; i < bishops.length; i++) {
				String bishop = bishops[i];
				int x = bishop.charAt(1) - '1';
				int y = bishop.charAt(0) - 'A';
				check[x][y] = true;
				
				for (int d = 0; d < 4; d++) {
					int cx = x;
					int cy = y;
					
					while (true) {
						int nx = cx + dx[d];
						int ny = cy + dy[d];
						
						if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) break;
						
						check[nx][ny] = true;
						cx = nx;
						cy = ny;
					}
				}
			}
			
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 8; j++)
					if (!check[i][j]) answer++;
					
			
        return answer;
    }


