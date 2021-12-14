import java.util.*;

public class Main {

    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]); 

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                answer.add(arr[i + 1]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int num : T.solution(arr)) {
            System.out.print(num + " ");
        }
    }
}
