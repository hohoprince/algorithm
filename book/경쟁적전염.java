package main;

import java.util.*;

class Virus implements Comparable<Virus> {
    private int number;
    private int x;
    private int y;
    private int time;

    public Virus(int number, int x, int y, int time) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Virus o) {
        return number - o.getNumber();
    }
}

public class Main {

    public static int n, k, s, x, y;
    public static int[][] arr;

    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    public static Queue<Virus> q = new LinkedList<>();
    public static int time = 0;


    public static void infect(int x, int y) {

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = arr[x][y];
                    q.offer(new Virus(arr[nx][ny], nx, ny, time));
                }
            }

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n][n];
        List<Virus> virusList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int number = sc.nextInt();
                arr[i][j] = number;
                if (number != 0) {
                    virusList.add(new Virus(number, i, j, 0));
                }
            }
        }

        s = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();

        Collections.sort(virusList);

        virusList.forEach(q::offer);

        while (!q.isEmpty()) {
            Virus v = q.poll();
            if (time == v.getTime()) {
                time++;
            }
            if (time - 1 == s) {
                break;
            }
            infect(v.getX(), v.getY());
        }
        
        System.out.println(arr[x - 1][y - 1]);

    }

}

/*
3 3
1 0 2
0 0 0
3 0 0
2 3 2

3 3
1 0 2
0 0 0
3 0 0
1 2 2
 */
