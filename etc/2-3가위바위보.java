import java.util.*;

public class Main {

    public char[] solution(int n, int[] arrA, int[] arrB) {
        char[] answer = new char[n];

        for (int i = 0; i < n; i++) {
            if (arrA[i] == arrB[i]) answer[i] = 'D';
            else if (arrA[i] == 1 && arrB[i] == 3) answer[i] = 'A';
            else if (arrA[i] == 2 && arrB[i] == 1) answer[i] = 'A';
            else if (arrA[i] == 3 && arrB[i] == 2) answer[i] = 'A';
            else answer[i] = 'B';
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arrB[i] = sc.nextInt();
        }

        for (char c : T.solution(n, arrA, arrB)) {
            System.out.println(c);
        }
    }
}
