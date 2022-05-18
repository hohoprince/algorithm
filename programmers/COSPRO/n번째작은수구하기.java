// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    public int solution(int[] card, int n) {	
				Set<Integer> set = new HashSet<>();
				boolean[] visited = new boolean[card.length];
				
				backtrack(card, 0, 0, set, visited);
				
				List<Integer> list = new ArrayList<>(set);
				list.sort(Comparator.naturalOrder());
				
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) == n) {
						return i + 1;
					}
				}
			
        return -1;
    }
	
		private void backtrack(int[] card, int depth, int num, Set<Integer> set, boolean[] visited) {
			if (depth == card.length) {
				if (!set.contains(num)) {
					set.add(num);
				}
				return;
			}
			
			for (int i = 0; i < card.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					backtrack(card, depth + 1, num * 10 + card[i], set, visited);
					visited[i] = false;
				}
			}
		}
    

