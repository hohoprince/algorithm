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

    public int dfs(int len, Node root) {
        if (root.left == null && root.right == null) {
            return len;
        }
        return Math.min(dfs(len + 1, root.left), dfs(len + 1, root.right));
    }

    public static void main(String[] args) {
        Main T = new Main();

        Node root = new Node(1,
                new Node(2,
                        new Node(4, null, null),
                        new Node(5, null, null)),
                new Node(3, null, null));

        System.out.println(T.dfs(0, root));

    }
}
