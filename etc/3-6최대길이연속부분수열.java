import java.util.*;

public class Main {

    public int solution(int n, int k, int[] arr) {
        int answer = Integer.MIN_VALUE;
        int zeroCount = 0;
        int curLength = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int end = 0; end < n; end++) {
            curLength++;
            if (arr[end] == 1) {
                answer = Math.max(curLength, answer);
            } else {
                zeroCount++;
                queue.offer(end);
                if (zeroCount > k) {
                    int index = queue.poll();
                    curLength = end - index;
                    answer = Math.max(curLength, answer);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }
}
