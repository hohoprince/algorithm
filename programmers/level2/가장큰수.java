import java.util.*;

public class Main {

    public String solution(int[] numbers) {
        List<String> numList = new ArrayList<>();

        for (int x : numbers) {
            numList.add(String.valueOf(x));
        }

        numList.sort((n1, n2) -> {
            int num1 = Integer.parseInt(n1 + n2);
            int num2 = Integer.parseInt(n2 + n1);

            return num2 - num1;
        });

        StringBuilder sb = new StringBuilder();

        for (String x : numList) {
            if (sb.length() == 0 && x.equals("0")) continue;
            sb.append(x);
        }

        if (sb.length() == 0) sb.append("0");

        return sb.toString();
    }



    public static void main(String[] args) {
        Main M = new Main();

        int[] numbers = {3, 30, 34, 5, 9};

        System.out.println(M.solution(numbers));
    }
}
