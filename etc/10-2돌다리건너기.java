import java.util.Scanner;

public class Main {

    static int[] value;

    int solution(int n) {
        for (int i = 3; i <=n ; i++) {
            value[i] = value[i - 1] + value[i - 2];
        }

        return value[n];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        value = new int[n + 2];
        value[1] = 1;
        value[2] = 2;
        System.out.println(T.solution(n + 1));
    }
}
