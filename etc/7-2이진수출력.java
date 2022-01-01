import java.util.*;


public class Main {


    public void solution(int x) {
        if (x == 0) {
            return;
        }
        int remain = x % 2;
        solution(x / 2);
        System.out.print(remain);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        T.solution(n);
    }
}
