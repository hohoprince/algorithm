
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int n;
    public static char[][] school;
    public static boolean result = false;
    public static int count = 0;

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static boolean watch(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x;
            int ny = y;

            while (true) {
                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || school[nx][ny] == 'O') break;
                if (school[nx][ny] == 'S') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void search() {
        if (count == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (school[i][j] == 'T') {
                        if (watch(i, j)) {
                            return;
                        }
                    }
                }
            }
            result = true;
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (school[i][j] == 'X') {
                    school[i][j] = 'O';
                    count++;
                    search();
                    school[i][j] = 'X';
                    count--;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        school = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                school[i][j] = sc.next().charAt(0);
            }
        }

        search();

        if (result) System.out.println("YES");
        else System.out.println("NO");

    }

}
