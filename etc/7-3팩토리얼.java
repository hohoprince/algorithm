import java.util.*;


public class Main {


    public int solution(int x) {
        if (x == 1) {
            return 1;
        }
        return x * solution(x - 1);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
