import java.util.*;

class Time {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Time{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class Main {


    static int solution(int n, List<Time> arr) {
        int answer = 1;

        arr.sort((t1, t2) -> t1.end == t2.end ? t1.start - t2.start : t1.end - t2.end);

        int endTime = arr.get(0).end;
        for (int i = 1; i < arr.size(); i++) {
            if (endTime <= arr.get(i).start) {
                answer++;
                endTime = arr.get(i).end;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Time> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new Time(sc.nextInt(), sc.nextInt()));
        }

        System.out.println(solution(n, arr));
    }
}
