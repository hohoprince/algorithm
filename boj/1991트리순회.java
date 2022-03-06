import java.util.*;

class Node {
    char c;
    Node left = null;
    Node right = null;

    public Node(char c) {
        this.c = c;
    }
}

public class Main {

    private static String solution(Node root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.append('\n');
        inorder(root, sb);
        sb.append('\n');
        postorder(root, sb);

        return sb.toString();
    }

    private static void preorder(Node node, StringBuilder sb) {
        if (node == null) return;

        sb.append(node.c);
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    private static void inorder(Node node, StringBuilder sb) {
        if (node == null) return;

        inorder(node.left, sb);
        sb.append(node.c);
        inorder(node.right, sb);
    }

    private static void postorder(Node node, StringBuilder sb) {
        if (node == null) return;

        postorder(node.left, sb);
        postorder(node.right, sb);
        sb.append(node.c);
    }

    private static void setChild(Node node, char c, char left, char right) {
        if (node == null) return;

        if (node.c == c) {
            if (left != '.') {
                node.left = new Node(left);
            }
            if (right != '.') {
                node.right = new Node(right);
            }
            return;
        }
        setChild(node.left, c, left, right);
        setChild(node.right, c, left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node root = new Node('A');

        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);

            setChild(root, c, left, right);
        }

        System.out.println(solution(root));
    }

}
