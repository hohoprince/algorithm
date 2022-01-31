import java.util.*;

public class Main {

    static int minValue = Integer.MAX_VALUE;

    static void dfs(List<List<Integer>> result, LinkedList<Integer> tmp, List<Integer> team, int start) {
        if (tmp.size() == 2) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < team.size(); i++) {
            tmp.add(team.get(i));
            dfs(result, tmp, team, i + 1);
            tmp.removeLast();
        }
    }

    static List<List<Integer>> getCombination(List<Integer> team) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> tmp = new LinkedList<>();

        dfs(result, tmp, team, 0);

        return result;
    }

    static int getScore(int n, Set<Integer> set, int[][] table) {
        int score1 = 0;
        int score2 = 0;
        List<Integer> team1 = new ArrayList<>();
        List<Integer> team2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (set.contains(i)) {
                team1.add(i);
            } else {
                team2.add(i);
            }
        }

        List<List<Integer>> team1Combination = getCombination(team1);
        List<List<Integer>> team2Combination = getCombination(team2);

        for (int i = 0; i < team1Combination.size(); i++) {
            score1 += table[team1Combination.get(i).get(0)][team1Combination.get(i).get(1)] +
                    table[team1Combination.get(i).get(1)][team1Combination.get(i).get(0)];
            score2 += table[team2Combination.get(i).get(0)][team2Combination.get(i).get(1)] +
                    table[team2Combination.get(i).get(1)][team2Combination.get(i).get(0)];
        }

        return Math.abs(score1 - score2);
    }

    static void solution(int n, int start, Set<Integer> set, int[][] table) {
        if (set.size() == n / 2) {
            minValue = Math.min(minValue, getScore(n, set, table));
            return;
        }

        for (int i = start; i < n; i++) {
            set.add(i);
            solution(n, i + 1, set, table);
            set.remove(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] table = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        Set<Integer> set = new HashSet<>();
        solution(n, 0, set, table);

        System.out.println(minValue);
    }
}
