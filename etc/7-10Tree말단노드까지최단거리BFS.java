import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {

    public int bfs(int len, Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            depth++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();

        Node root = new Node(1,
                new Node(2,
                        new Node(4, null, null),
                        new Node(5, null, null)),
                new Node(3, null, null));

        System.out.println(T.bfs(0, root));

    }
}