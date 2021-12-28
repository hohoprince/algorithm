import java.util.*;

public class Main {

    public String solution(int n, int[] arr) {
        Set<Integer> set = new HashSet<>();
        
        for (int x : arr) {
            if (set.contains(x)) {
                return "D";
            }
            set.add(x);
        }
        return "U";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, arr));
        
//        for (int x : T.solution(n, arr)) {
//            System.out.print(x + " ");
//        }

    }
}
