package main;


import java.util.*;

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

    public static int n;
    public static int m;
    public static List<Position> arr = new ArrayList<>();
    public static List<List<Position>> combination = new ArrayList<>();

    public static void createCombination(List<Position> stores, int start) {

        if (arr.size() == m) {
            combination.add(new ArrayList<>(arr));
            return;
        }

        for (int i = start; i < stores.size(); i++) {
            arr.add(stores.get(i));
            createCombination(stores, i + 1);
            arr.remove(arr.size() - 1);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        List<Position> houses = new ArrayList<>();
        List<Position> stores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                if (num == 1) {
                    houses.add(new Position(i, j));
                } else if (num == 2) {
                    stores.add(new Position(i, j));
                }
            }
        }

        createCombination(stores, 0);

        int result = Integer.MAX_VALUE;

        for (List<Position> selectedStores : combination) {
            int sum = 0;
            for (Position house : houses) {
                int minValue = Integer.MAX_VALUE;
                for (Position store : selectedStores) {
                    minValue = Math.min(minValue,
                            Math.abs(house.getX() - store.getX()) + Math.abs(house.getY() - store.getY()));
                }
                sum += minValue;
            }
            result = Math.min(sum, result);
        }

        System.out.println(result);
    }

}

/*
ex1
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2

ex 2
5 2
0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
2 0 0 1 1
2 2 0 1 2
 */
