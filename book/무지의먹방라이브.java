import java.util.*;

class Food implements Comparable<Food> {
    
    int foodNumber;
    int time;
    
    public Food(int foodNumber, int time) {
        this.foodNumber = foodNumber;
        this.time = time;
    }
    
    @Override
    public int compareTo(Food o) {
        return Integer.compare(this.time, o.time);
    }
    
    @Override
    public String toString() {
        return "num: " + this.foodNumber + " time: " + this.time;
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        int numOfFoods = food_times.length;
        
        int sum = 0;
        for (int i = 0; i < numOfFoods; i++) {
            sum += food_times[i];
        }
        if (sum <= k) {
            return -1;
        }
        
        PriorityQueue<Food> pq = new PriorityQueue<>();
        
        
        for (int i = 0; i < numOfFoods; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
        }
        
        int prev = 0;
        int left = numOfFoods;
        
        while (left * (pq.peek().time - prev) <= k) {
            Food now = pq.poll();
            k -= left * (now.time - prev);
            prev = now.time;
            left--;
        }
        
        List<Food> result = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        
        Collections.sort(result, (a, b) -> Integer.compare(a.foodNumber, b.foodNumber));
        
        return result.get((int) k % left).foodNumber;
            
        
    }
}
