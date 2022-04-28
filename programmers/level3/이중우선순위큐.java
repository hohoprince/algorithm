import java.util.*;

public class Main {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (String operation : operations) {
            String[] s = operation.split(" ");
            if (s[0].equals("I")) {
                int num = Integer.parseInt(s[1]);
                maxHeap.offer(num);
                minHeap.offer(num);
            } else if (s[0].equals("D")) {
                if (s[1].equals("1")) {
                    Integer poll = maxHeap.poll();
                    minHeap.remove(poll);
                } else if (s[1].equals("-1")) {
                    Integer poll = minHeap.poll();
                    maxHeap.remove(poll);
                }
            }
        }

        int[] answer = new int[2];

        if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();

        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        System.out.println(Arrays.toString(M.solution(operations)));
    }
}
