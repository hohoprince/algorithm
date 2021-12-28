import java.util.*;


public class Main {

    public int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;
        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }

        return cnt;
    }

    public int solution(int n, int m, int[] arr) {

        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;

//        int start = Integer.MIN_VALUE;
//        int end = 0;
//        int answer = 0;
//
//        for (int x : arr) {
//            end += x;
//            start = Math.max(start, x);
//        }
//
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            int sum = 0;
//            int count = 0;
//            for (int x : arr) {
//                sum += x;
//                if (sum == mid) {
//                    count++;
//                    sum = 0;
//                } else if (sum > mid) {
//                    sum = x;
//                    count++;
//                }
//            }
//
//            if (sum > 0) {
//                count++;
//            }
//
//            if (count <= m) {
//                answer = mid;
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//
//        return answer;
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
