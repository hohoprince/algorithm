import java.sql.Time;
import java.util.*;

public class Main {


    static int solution(int n, List<Integer> arr) {
        int answer = 0;

        Collections.sort(arr);

        for (int i = 0; i < n; i++) {
            answer += arr.get(i) * (n - i) ;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println(solution(n, arr));
    }
}
