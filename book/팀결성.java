package main;

import java.util.Scanner;

public class Main {

    public static int n, m;

    public static int[] parent;


    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int command = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (command == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }

    }
}

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */
