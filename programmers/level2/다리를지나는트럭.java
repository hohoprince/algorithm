import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[] { 7, 4, 5, 6 }));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truckWeightIndex = 0;
        int complete = 0;

        List<Truck> bridge = new ArrayList<>();

        while (true) {
            answer++;
            if (truck_weights.length > truckWeightIndex) {
                if (sum(bridge) + truck_weights[truckWeightIndex] <= weight) {
                    bridge.add(new Truck(truck_weights[truckWeightIndex]));
                    truckWeightIndex++;
                }
            }
            increaseTime(bridge);
            if (bridge.get(0).time == bridge_length) {
                bridge.remove(0);
                complete++;
                if (complete == truck_weights.length) {
                    return answer + 1;
                }
            }
        }
    }

    static class Truck {
        public int weight;
        public int time;

        public Truck(int weight) {
            this.weight = weight;
            this.time = 0;
        }
    }

    private static int sum(List<Truck> li) {
        int sum = 0;
        for (Truck t : li) {
            sum += t.weight;
        }
        return sum;
    }

    private static void increaseTime(List<Truck> li) {
        for (Truck t : li) {
            t.time++;
        }
    }

}
