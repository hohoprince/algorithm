import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
    int number;
    int cost;

    public Node(int number, int cost) {
        this.number = number;
        this.cost = cost;
    }
}

public class Main {
    static int v;
    static int e;
    static List<List<Node>> graph;
    static boolean[] check;

    int solution() {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1 , n2) -> n1.cost - n2.cost);

        int totalCost = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (check[curNode.number]) continue;

            check[curNode.number] = true;
            totalCost += curNode.cost;
            for (Node adjNode : graph.get(curNode.number)) {
                if (!check[adjNode.number]) pq.offer(adjNode);
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        graph = new ArrayList<>();
        check = new boolean[v + 1];

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        System.out.println(T.solution());
    }
}
