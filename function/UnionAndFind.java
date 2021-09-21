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
