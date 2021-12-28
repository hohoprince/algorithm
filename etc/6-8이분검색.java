import java.awt.*;
import java.util.*;
import java.util.List;


public class Main {

    public int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == m) {
                return mid + 1;
            } else if (arr[mid] < m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        return start;
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
