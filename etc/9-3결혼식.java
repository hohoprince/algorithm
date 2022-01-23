import java.util.*;

class Info implements Comparable<Info> {
    int time;
    boolean isStart;

    public Info(int time, boolean isStart) {
        this.time = time;
        this.isStart = isStart;
    }

    @Override
    public int compareTo(Info o) {
        if (this.time == o.time) {
            return Boolean.compare(this.isStart, o.isStart);
        } else {
            return this.time - o.time;
        }
    }

    @Override
    public String toString() {
        return "Info{" +
                "time=" + time +
                ", isStart=" + isStart +
                '}';
    }
}

public class Main {

    int solution(int n, Info[] infos) {
        int maxCount = 0;
        int count = 0;

        Arrays.sort(infos);

        for (Info info : infos) {
            if (info.isStart) {
                count++;
            } else {
                count--;
            }
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Info[] infos = new Info[2 * n];
        for (int i = 0; i < 2 * n; i += 2) {
            infos[i] = new Info(sc.nextInt(), true);
            infos[i + 1] = new Info(sc.nextInt(), false);
        }

        System.out.println(T.solution(n, infos));
    }
}

