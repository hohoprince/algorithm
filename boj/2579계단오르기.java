import java.util.*;

public class Main {

    static int solution(int n, int[] arr) {
        int[] one = new int[n];
        int[] two = new int[n];

        one[0] = arr[0];
        two[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if (i == 1) {
                one[i] = arr[0] + arr[1];
                two[i] = arr[1];
            } else {
                one[i] = two[i - 1] + arr[i];
                two[i] = Math.max(one[i - 2], two[i - 2]) + arr[i];
            }
        }
        
        return Math.max(one[n - 1], two[n - 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, arr));
    }
}
