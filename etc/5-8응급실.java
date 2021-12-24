import java.util.*;

class Patient {
    private int index;
    private int priority;

    public Patient(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public int getIndex() {
        return index;
    }

    public int getPriority() {
        return priority;
    }
}

public class Main {

    public int solution(int n, int m, int[] arr) {
        Queue<Patient> queue = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            queue.offer(new Patient(i, arr[i]));
        }

        while (!queue.isEmpty()) {
            Patient p = queue.poll();
            boolean isFirst = true;
            for (Patient x : queue) {
                if (p.getPriority() < x.getPriority()) {
                    isFirst = false;
                    break;
                }
            }
            if (isFirst) {
                answer++;
                if (p.getIndex() == m) {
                    return answer;
                }
            } else {
                queue.offer(p);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
