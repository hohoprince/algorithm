class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length, (a, b) -> a - b);
        
        pq.add(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) pq.poll();
            
            pq.add(intervals[i][1]);
        }
        
        return pq.size();
    }
}
