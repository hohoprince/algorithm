import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int l, c;
    static char[] tmp;

    static void dfs(int start, int depth, int l, char[] arr) {
        int count1 = 0;
        int count2 = 0;

        if (depth == l) {
            for (char x : tmp) {
                if (x == 'a' || x == 'e' || x == 'i' || x == 'u' || x == 'o') {
                    count1++;
                } else {
                    count2++;
                }
            }
            if (count1 >= 1 && count2 >= 2) {
                System.out.println(new String(tmp));
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            tmp[depth] = arr[i];
            dfs(i + 1, depth + 1, l, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        l = sc.nextInt();
        c = sc.nextInt();

        char[] arr = new char[c];
        tmp = new char[l];

        for (int i = 0; i < c; i++) {
            arr[i] = sc.next().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, 0, l, arr);

    }
}
