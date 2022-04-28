import java.util.*;

public class Main {

    private int answer = 0;
    private boolean[] checked;
    private Set<Integer> set;

    public int solution(String numbers) {
        String[] split = numbers.split("");
        checked = new boolean[split.length];
        set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= split.length; i++) {
            dfs(split, sb, i);
        }

        return answer;
    }

    private void dfs(String[] split, StringBuilder sb, int length) {
        if (sb.length() == length) {
            int num = Integer.parseInt(sb.toString());
            if (isPrime(num) && !set.contains(num)) {
                answer++;
                set.add(num);
            }

            return;
        }

        for (int i = 0; i < split.length; i++) {
            if (!checked[i]) {
                sb.append(split[i]);
                checked[i] = true;
                dfs(split, sb, length);
                sb.deleteCharAt(sb.length() - 1);
                checked[i] = false;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        Main M = new Main();

//        String numbers = "17";
        String numbers = "011";

        System.out.println(M.solution(numbers));
    }
}

