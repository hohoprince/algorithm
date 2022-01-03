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

    public void bfs(Node x) {
        Queue<Node> q = new LinkedList<>();

        q.offer(x);

        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();

        Node root = new Node(1,
                new Node(2,
                        new Node(4, null, null),
                        new Node(5, null, null)),
                new Node(3,
                        new Node(6, null, null),
                        new Node(7, null, null)));

        T.bfs(root);

    }
}
