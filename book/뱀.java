package main;


import java.util.*;

class Location {
    private int row;
    private int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] board = new int[n][n];

        int numOfApples = sc.nextInt();
        for (int i = 0; i < numOfApples; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            board[row][col] = 2;
        }

        Map<Integer, Character> map = new HashMap<>();

        int change = sc.nextInt();
        for (int i = 0; i < change; i++) {
            int time = sc.nextInt();
            char c = sc.next().charAt(0);
            map.put(time, c);
        }

        int rowOffsets[] = { -1, 0, 1, 0 };
        int colOffsets[] = { 0, 1, 0, -1 };

        int row = 0;
        int col = 0;
        int offsetIndex = 1;
        int time = 0;

        Queue<Location> q = new LinkedList<>();
        q.offer(new Location(0, 0));

        while (true) {
            time++;
            row += rowOffsets[offsetIndex];
            col += colOffsets[offsetIndex];

            if (row < 0 || row >= n || col < 0 || col >= n || board[row][col] == 1) {
                break;
            }

            q.offer(new Location(row, col));

            if (board[row][col] != 2) {
                Location l = q.poll();
                board[l.getRow()][l.getCol()] = 0;
            }
            board[row][col] = 1;

            if (map.containsKey(time)) {
                char c = map.get(time);
                if (c == 'D') {
                    offsetIndex = (offsetIndex + 1) % 4;
                } else if (c == 'L') {
                    offsetIndex -= 1;
                    if (offsetIndex < 0) {
                        offsetIndex += 4;
                    }
                }
            }

        }

        System.out.println(time);

    }

}

/*
ex 1
6
3
3 4
2 5
5 3
3
3 D
15 L
17 D

ex 2
10
4
1 2
1 3
1 4
1 5
4
8 D
10 D
11 D
13 L

ex 3
10
5
1 5
1 3
1 2
1 6
1 7
4
8 D
10 D
11 D
13 L
 */
