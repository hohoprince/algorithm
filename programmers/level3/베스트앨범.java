import java.util.*;

class Play implements Comparable<Play> {
    int index;
    int value;

    public Play(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Play o) {
        if (this.value == o.value) {
            return this.index - o.index;
        }
        return o.value - this.value;
    }

    @Override
    public String toString() {
        return "Play{" +
                "index=" + index +
                ", value=" + value +
                '}';
    }
}

public class Main {

    private int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, PriorityQueue<Play>> priorityQueueMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);

            if (!priorityQueueMap.containsKey(genres[i])) {
                priorityQueueMap.put(genres[i], new PriorityQueue<>());
            }

            PriorityQueue<Play> pq = priorityQueueMap.get(genres[i]);
            pq.offer(new Play(i, plays[i]));
        }

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(sumMap.entrySet());
        entries.sort((e1, e2) -> e2.getValue() - e1.getValue());

        List<Integer> answerList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            PriorityQueue<Play> playPq = priorityQueueMap.get(key);
            for (int i = 0; i < 2; i++) {
                if (!playPq.isEmpty()) {
                    Play play = playPq.poll();
                    answerList.add(play.index);
                }
            }
        }

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] answer = M.solution(genres, plays);

        System.out.println(Arrays.toString(answer));
    }
}
