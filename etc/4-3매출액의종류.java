import java.util.*;

public class Main {

    public List<Integer> solution(int n, int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int start = 0;
        for (int end = k - 1; end < n; end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            answer.add(map.size());
            if (map.get(arr[start]) == 1) {
                map.remove(arr[start]);
            } else {
                map.put(arr[start], map.get(arr[start]) - 1);
            }
            start++;
        }


        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (Integer integer : T.solution(n, k, arr)) {
            System.out.print(integer + " ");
        }
    }
}
