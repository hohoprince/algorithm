import java.util.*;

public class Main {

    private static Queue<char[]> queue;

    private static int solution(int n, int k) {
        char[] num = String.valueOf(n).toCharArray();
        queue.offer(num);

        for (int i = 0; i < k; i++) {
            Set<String> set = new HashSet<>();
            int queueSize = queue.size();
            for (int j = 0; j < queueSize; j++) {
                char[] poll = queue.poll();

                String str = String.valueOf(poll);

                if (set.contains(str)) {
                    continue;
                } else {
                    set.add(str);
                }

                for (int l = 0; l < poll.length - 1; l++) {
                    for (int m = l + 1; m < poll.length; m++) {
                        if (l != 0 || poll[m] != '0') {
                            char[] tmpArr = poll.clone();
                            char tmp = tmpArr[l];
                            tmpArr[l] = tmpArr[m];
                            tmpArr[m] = tmp;
                            queue.offer(tmpArr);
                        }
                    }
                }
            }
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            char[] poll = queue.poll();
            answer = Math.max(answer, Integer.parseInt(String.valueOf(poll)));
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        queue = new LinkedList<>();
        int answer = solution(n, k);
        System.out.println(answer == 0 ? -1 : answer);
    }
}
