import java.util.*;


public class Main {


    public int solution(int n, int c, int[] arr) {
        int start = 1;
        int end = arr[arr.length - 1] - arr[0];
        int answer = 0;

        Arrays.sort(arr);

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 1;
            int cur = arr[0];
            for (int x : arr) {
                if (x >= cur + mid) {
                    cur = x;
                    count++;
                }
            }

            if (count >= c) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, c, arr));

    }
}
