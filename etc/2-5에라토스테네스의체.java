import java.util.*;

public class Main {

    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + i) {
                    ch[j] = 1;
                }
            }
        }

        return answer;

//        내 풀이
//        int answer = 0;
//
//        boolean[] primes = new boolean[n + 1];
//        Arrays.fill(primes, true);
//
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if (primes[i]) {
//                int j = 2;
//                while (i * j <= n) {
//                    primes[i * j] = false;
//                    j++;
//                }
//            }
//        }
//
//        for (int i = 2; i <= n; i++) {
//            if (primes[i]) answer++;
//        }
//
//        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
