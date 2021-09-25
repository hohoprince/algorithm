package main;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Country {
    private int population;
    private int x;
    private int y;

    public Country(int population, int x, int y) {
        this.population = population;
        this.x = x;
        this.y = y;
    }

    public int getPopulation() {
        return population;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {

    public static int n, l, r;
    public static int[][] land;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};


    public static void createGroup(int x, int y, boolean[][] visited, List<Country> group) {
        visited[x][y] = true;
        group.add(new Country(land[x][y], x, y));

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
            int diff = Math.abs(land[nx][ny] - land[x][y]);
            if (l <= diff && diff <= r) {
                createGroup(nx, ny, visited, group);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        land = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                land[i][j] = sc.nextInt();
            }
        }

        int day = 0;

        while (true) {
            boolean[][] visited = new boolean[n][n];
            List<List<Country>> groups = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    List<Country> group = new ArrayList<>();
                    createGroup(i, j, visited, group);
                    if (group.size() > 1) {
                        groups.add(group);
                    }
                }
            }

            if (groups.isEmpty()) break;

            for (List<Country> countries : groups) {
                int sum = 0;
                for (Country c : countries) {
                    sum += c.getPopulation();
                }

                int population = sum / countries.size();
                for (Country c : countries) {
                    land[c.getX()][c.getY()] = population;
                }
            }
            day++;
        }

        System.out.println(day);
    }

}

/*
3 5 10
10 15 20
20 30 25
40 22 10

4 10 50
10 100 20 90
80 100 60 70
70 20 30 40
50 20 100 10
 */

