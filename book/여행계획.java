package main;


import java.util.*;


public class Main {

    public static int n, m;
    public static int[] parent;

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        parent = new int[n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                if (num == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        int[] plan = new int[m];
        for (int i = 0; i < m; i++) {
            plan[i] = sc.nextInt();
        }

        int start = find(plan[0]);

        boolean result = true;
        for (int i = 1; i < m; i++) {
            if (start != find(plan[i])) {
                result = false;
            }
        }

        if (result) System.out.println("YES");
        else System.out.println("NO");
    }

}

/*
5 4
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
2 3 4 3
 */
