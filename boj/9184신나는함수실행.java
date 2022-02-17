import java.util.Scanner;

public class Main {

    static int[][][] values = new int[51][51][51];

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (values[a][b][c] != 0) {
            return values[a][b][c];
        }

        if (a > 20 || b > 20 || c > 20) {
            return values[a][b][c] = w(20, 20, 20);
        }
        if (a < b && b < c) {

            return values[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            return values[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c)
                    + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == -1 && b == -1 && c == -1) break;

            System.out.printf("w(%d, %d, %d) = %d%n", a, b, c, w(a, b, c));
        }
    }
}
