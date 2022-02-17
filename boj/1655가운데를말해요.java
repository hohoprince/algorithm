import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> solution(int n, List<Integer> nums) {
        List<Integer> answer = new ArrayList<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int x : nums) {
            if (maxHeap.isEmpty() || maxHeap.peek() > x || !minHeap.isEmpty() && minHeap.peek() > x) {
                maxHeap.offer(x);
            } else {
                minHeap.offer(x);
            }
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
            answer.add(maxHeap.peek());
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = new ArrayList<>();

        try {
            n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                nums.add(Integer.parseInt(bufferedReader.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        for (int x : solution(n, nums)) {
            sb.append(x).append('\n');
        }

        System.out.println(sb);

    }
}
