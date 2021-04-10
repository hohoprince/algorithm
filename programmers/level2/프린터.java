import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
    }

    public static int solution(int[] priorities, int location) {
        class Tuple {
            public int index, priority;

            public Tuple(int index, int priority) {
                this.index = index;
                this.priority = priority;
            }
        }

        Queue<Tuple> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Tuple(i, priorities[i]));
        }

        int count = 0;

        Loop : while (true) {
            Tuple t = q.poll();
            for (Tuple tt : q) {
                if (t.priority < tt.priority) {
                    q.offer(t);
                    continue Loop;
                }
            }
            count++;
            if (t.index == location) {
                return count;
            }
        }
    }
}

