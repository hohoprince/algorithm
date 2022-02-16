import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tower {
    int num;
    int index;

    public Tower(int num, int index) {
        this.num = num;
        this.index = index;
    }
}

public class Main {

    static int[] solution(int n, int[] heights) {
        Stack<Tower> stack = new Stack<>();
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int curr = heights[i];
            if (!stack.isEmpty()) {
                Tower peeked = stack.peek();
                if (peeked.num > curr) {
                    answer[i] = peeked.index + 1;
                } else {
                    while (!stack.isEmpty() && stack.peek().num < curr) {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        answer[i] = stack.peek().index + 1;
                    }
                }
            }
            stack.push(new Tower(curr, i));
        }

        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        int[] heights = null;
        try {
            n = Integer.parseInt(br.readLine());
            heights = new int[n];
            String s = br.readLine();
            String[] tmp = s.split(" ");
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(tmp[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();

        for (int x : solution(n, heights)) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
