import java.util.*;

class Time implements Comparable<Time> {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (o.end == this.end) {
            return Integer.compare(this.start, o.start);
        } else {
            return Integer.compare(this.end, o.end);
        }
    }
}

public class Main {

    int solution(int n, Time[] times) {
        Arrays.sort(times);

        int count = 1;
        int tmp = times[0].end;
        for (int i = 1; i < n; i++) {
            if (tmp <= times[i].start) {
                count++;
                tmp = times[i].end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Time[] times = new Time[n];

        for (int i = 0; i < n; i++) {
            times[i] = new Time(sc.nextInt(), sc.nextInt());
        }

        System.out.println(T.solution(n, times));
    }
}

