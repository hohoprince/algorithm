import java.util.*;

public class Main {

    public List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        int[] tmp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);

        for (int i = 0; i < n; i++) {
            if (tmp[i] != arr[i]) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }

    }
}
