import java.util.*;

class Food implements Comparable<Food> {
    
    private int foodNumber;
    private int time;
    
    public Food(int foodNumber, int time) {
        this.foodNumber = foodNumber;
        this.time = time;
    }
    
    public int getFoodNumber() {
        return this.foodNumber;
    }
    
    public int getTime() {
        return this.time;
    }
    
    @Override
    public int compareTo(Food o) { 
        return Integer.compare(this.time, o.getTime());
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        int numOfFoods = food_times.length;
        
        long sum = 0;
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
        
        long prev = 0;
        long left = numOfFoods;
        
        while (left * (pq.peek().getTime() - prev) <= k) {
            int now = pq.poll().getTime();
            k -= left * (now - prev);
            prev = now;
            left -= 1;
        }
        
        List<Food> result = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        
        Collections.sort(result, new Comparator<Food>() { 
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.getFoodNumber(), b.getFoodNumber());
            }
        });
        
        return result.get((int) (k % left)).getFoodNumber();
            
        
    }
}
