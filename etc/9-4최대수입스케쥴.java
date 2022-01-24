import java.util.*;

class Lecture {
    int m;
    int d;

    public Lecture(int m, int d) {
        this.m = m;
        this.d = d;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "m=" + m +
                ", d=" + d +
                '}';
    }
}

public class Main {

    int solution(int n, List<Lecture> lectures) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        lectures.sort((l1, l2) -> l2.d - l1.d);

        int sum = 0;
        int maxDay = lectures.get(0).d;
        int index = 0;

        for (int day = maxDay; day > 0; day--) {
            while (index < n && day == lectures.get(index).d) {
                pq.offer(lectures.get(index++).m);
            }
            if (!pq.isEmpty()) sum += pq.poll();
        }

        return sum;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lectures.add(new Lecture(sc.nextInt(), sc.nextInt()));
        }

        System.out.println(T.solution(n, lectures));

    }
}

