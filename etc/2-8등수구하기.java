import java.util.*;

public class Main {

    public int[] solution(int n, List<Integer> arr) {
        int[] answer = new int[n];
        List<Integer> tmp = new ArrayList<>(arr);
        tmp.sort(Collections.reverseOrder());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tmp.size(); i++) {
            if (!map.containsKey(tmp.get(i))) {
                map.put(tmp.get(i), i + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            answer[i] = map.get(arr.get(i));
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
