import java.util.*;

public class Main {

    public List<Integer> solution(int s, int n, int[] arr) {
        LinkedList<Integer> answer = new LinkedList<>();
        for (int x : arr) {
            if (answer.contains(x)) {
                answer.remove((Object) x);
            } else {
                if (answer.size() == s) {
                    answer.removeLast();
                }
            }
            answer.addFirst(x);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : T.solution(s, n, arr)) {
            System.out.print(x + " ");
        }

    }
}
