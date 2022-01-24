import java.util.*;

class Relation {
    int friend1;
    int friend2;

    public Relation(int friend1, int friend2) {
        this.friend1 = friend1;
        this.friend2 = friend2;
    }
}

public class Main {

    int[] parents;

    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parents[b] = a;
        else parents[a] = b;
    }

    int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    String solution(int n, int m, Relation[] relations, int friend1, int friend2) {
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        String answer = "NO";

        for (Relation relation: relations) {
            union(relation.friend1, relation.friend2);
        }

        if (find(friend1) == find(friend2)) {
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Relation[] relations = new Relation[m];
        for (int i = 0; i < m; i++) {
            relations[i] = new Relation(sc.nextInt(), sc.nextInt());
        }

        int friend1 = sc.nextInt();
        int friend2 = sc.nextInt();

        System.out.println(T.solution(n, m, relations, friend1, friend2));

    }
}

