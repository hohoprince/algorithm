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

    public void inorder(Node x) {
        if (x == null) {
            return;
        }
        inorder(x.left);
        System.out.print(x.val + " ");
        inorder(x.right);
    }

    public void preorder(Node x) {
        if (x == null) {
            return;
        }
        System.out.print(x.val + " ");
        preorder(x.left);
        preorder(x.right);
    }

    public void postorder(Node x) {
        if (x == null) {
            return;
        }
        postorder(x.left);
        postorder(x.right);
        System.out.print(x.val + " ");
    }

    public static void main(String[] args) {
        Main T = new Main();

        Node node4 = new Node(4, null, null);
        Node node5 = new Node(5, null, null);
        Node node6 = new Node(6, null, null);
        Node node7 = new Node(7, null, null);

        Node node2 = new Node(2, node4, node5);
        Node node3 = new Node(3, node6, node7);

        Node root = new Node(1, node2, node3);

        System.out.print("inorder: ");
        T.inorder(root);
        System.out.println();

        System.out.print("preorder: ");
        T.preorder(root);
        System.out.println();

        System.out.print("postorder: ");
        T.postorder(root);
        System.out.println();
    }
}
