class Solution {
    public int solution(String s) {
        
        if (s.length() <= 1) return 1;
        
        int minValue = Integer.MAX_VALUE;

        for (int step = 1; step <= s.length() / 2; step++) {

            String prev = s.substring(0, step);
            int count = 1;
            StringBuilder str = new StringBuilder();

            for (int j = step; j < s.length(); j += step) {
                int end = Math.min(j + step, s.length());
                String sub = s.substring(j, end);
                if (prev.equals(sub)) count++;
                else {
                    str.append((count >= 2) ? count + prev : prev);
                    count = 1;
                    prev = sub;
                }
            }

            str.append((count >= 2) ? count + prev : prev);
            
            minValue = Math.min(str.length(), minValue);

        }

        return minValue;
    }
}
