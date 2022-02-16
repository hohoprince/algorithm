import java.util.*;

public class Main {

    static void solution(Deque<Integer> deque, StringBuilder sb, String c) {
        String[] command = c.split(" ");

        switch (command[0]) {
            case "push_front":
                deque.offerFirst(Integer.parseInt(command[1]));
                break;
            case "push_back":
                deque.offerLast(Integer.parseInt(command[1]));
                break;
            case "pop_front":
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
                break;
            case "pop_back":
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n');
                break;
            case "size":
                sb.append(deque.size()).append('\n');
                break;
            case "empty":
                sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                break;
            case "front":
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
                break;
            case "back":
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
                break;
            default:
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String c = sc.nextLine();
            solution(deque, sb, c);
        }

        System.out.println(sb);
    }
}
