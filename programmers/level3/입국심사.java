class Solution {
    public long solution(int n, int[] times) {
        int maxTime = 0;
        int minTime = 1_000_000_001;

        for (int time : times) {
            if (maxTime < time) {
                maxTime = time;
            }
            if (minTime > time) {
                minTime = time;
            }
        }

        long start = minTime;
        long end = maxTime * (long) n;

        long answer = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }

            if (sum < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}
