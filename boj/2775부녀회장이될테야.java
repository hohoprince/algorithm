import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int[][] apartment = new int[k + 1][n + 1];
            for (int j = 1; j <= n; j++) {
                apartment[0][j] = j;
            }

            for (int j = 1; j <= k; j++) {
                for (int l = 1; l <= n; l++) {
                    apartment[j][l] = apartment[j][l - 1] + apartment[j - 1][l];
                }
            }

            answer.add(apartment[k][n]);
        }

        for (int x : answer) {
            System.out.println(x);
        }
    }
}
