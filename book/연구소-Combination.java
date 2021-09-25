package main;

import java.util.*;

class Combination {

    private int n;
    private int r;
    private int[] now;
    private List<List<Position>> result;

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<>();
    }

    public List<List<Position>> getResult() {
        return result;
    }

    public void combination(List<Position> arr, int depth, int index, int target) {
        if (depth == r) {
            List<Position> temp = new ArrayList<>();
            for (int num : now) {
                temp.add(arr.get(num));
            }
            result.add(temp);
            return;
        }
        if (target == n) return;

        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }

}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {

    public static int n, m;
    public static int[][] lab;
    public static int[][] newLab;

    public static int[] rowOffsets = {-1, 0, 1, 0};
    public static int[] colOffsets = {0, 1, 0, -1};

    public static int count = 0;
    public static int maxCount = 0;
    public static List<Position> emptyPositions;

    public static void infect(int row, int col) {
        for (int d = 0; d < 4; d++) {
            int newRow = row + rowOffsets[d];
            int newCol = col + colOffsets[d];

            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) continue;

            if (newLab[newRow][newCol] == 0) {
                newLab[newRow][newCol] = 2;
                infect(newRow, newCol);
            }
        }

    }

    public static void dfs(List<Position> emptyPositions) {
        newLab = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newLab[i][j] = lab[i][j];
            }
        }

        emptyPositions.forEach(ep -> {
            newLab[ep.getX()][ep.getY()] = 1;
        });

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (newLab[row][col] == 2) {
                    infect(row, col);
                }
            }
        }

        int emptyCount = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (newLab[row][col] == 0) {
                    emptyCount++;
                }
            }
        }

        emptyPositions.forEach(ep -> {
            newLab[ep.getX()][ep.getY()] = 0;
        });

        maxCount = Math.max(emptyCount, maxCount);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        lab = new int[n][m];

        emptyPositions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lab[i][j] = sc.nextInt();
                if (lab[i][j] == 0) {
                    emptyPositions.add(new Position(i, j));
                }
            }
        }

        Combination comb = new Combination(emptyPositions.size(), 3);
        comb.combination(emptyPositions, 0, 0, 0);
        List<List<Position>> emptyPositionsList = comb.getResult();

        emptyPositionsList.forEach(Main::dfs);

        System.out.println(maxCount);

    }

}

/*
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2

8 8
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
 */

