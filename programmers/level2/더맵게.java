import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.offer(i);
        }

        int result = 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            if (first >= K) break;
            int second = pq.poll();
            pq.offer(first + second * 2);
            result++;
        }
        
        if (pq.size() == 1 && pq.poll() < K) result = -1;
        
        return result;
    }
}
