import java.util.*;

public class Main {

    public boolean isPrime(int x) {
        if (x < 2) return false;

        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if (isPrime(res)) answer.add(res);
        }

//        for (String s : arr) {
//            int x = Integer.parseInt(new StringBuilder(s).reverse().toString());
//            if (isPrime(x)) answer.add(x);
//        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        String[] arr = new String[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
//            arr[i] = sc.next();
            arr[i] = sc.nextInt();
        }

        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }

    }
}
