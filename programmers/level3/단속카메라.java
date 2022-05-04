import java.util.*;

class Section {
    int start;
    int end;

    public Section(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Section{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class Main {

    public int solution(int[][] routes) {
        int answer = 1;

        PriorityQueue<Section> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(s -> s.start));

        for (int[] route : routes) {
            priorityQueue.offer(new Section(route[0], route[1]));
        }

        Section firstSection = priorityQueue.poll();

        int start = firstSection.start;
        int end = firstSection.end;

        while (!priorityQueue.isEmpty()) {
            Section poll = priorityQueue.poll();
            start = Math.max(start, poll.start);
            end = Math.min(end, poll.end);

            if (start > end) {
                answer++;
                start = poll.start;
                end = poll.end;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();

        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};

        System.out.println(M.solution(routes));
    }
}

