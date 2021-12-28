import java.util.*;


public class Main {


    public void solution(int x) {
        if (x == 0) {
            return;
        }
        solution(x - 1);
        System.out.print(x + " ");
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        T.solution(n);
    }
}
