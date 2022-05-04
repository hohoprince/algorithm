import java.util.*;

public class Main {

    public int solution(int N, int number) {
        int answer = 1;

        if (N == number) return 1;

        List<Set<Integer>> setList = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            setList.add(new HashSet<>());
        }

        setList.get(1).add(N); // 1번 사용시 5

        for (int i = 2; i <= 9; i++) {
            if (i == 9) return -1;

            int num = N;
            for (int j = 1; j < i; j++) {
                num = num * 10 + N;
            }

            setList.get(i).add(num); // i번 사용 55, 555, 5555...

            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = setList.get(j);
                Set<Integer> set2 = setList.get(i - j);

                for (Integer i1 : set1) {
                    for (Integer i2 : set2) {
                        setList.get(i).add(i1 + i2);
                        setList.get(i).add(i1 - i2);
                        setList.get(i).add(i2 - i1);
                        setList.get(i).add(i1 * i2);
                        if (i2 != 0) {
                            setList.get(i).add(i1 / i2);
                        }
                        if (i1 != 0) {
                            setList.get(i).add(i2 / i1);
                        }
                    }
                }

                if (setList.get(i).contains(number)) return i;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();

        final int N = 5;
        final int number = 5;

        System.out.println(M.solution(N, number));
    }
}

