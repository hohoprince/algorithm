import java.util.*;


public class Main {

    static int[] fi;

    public int solution(int x) {
        if (x == 1) {
            return fi[x] = 1;
        } else if (x == 2) {
            return fi[x] = 1;
        } else {
            return fi[x] = solution(x - 2) + solution(x - 1);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        fi = new int[n + 1];

        T.solution(n);

        for (int i = 1; i <= n; i++) {
            System.out.print(fi[i] + " ");
        }
    }
}
