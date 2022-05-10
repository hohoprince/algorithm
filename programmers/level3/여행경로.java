import java.util.*;

public class Main {

    private boolean[] isUsed;
    private String[] answer;
    private boolean end;

    private void dfs(String cur, int depth, String[][] tickets, List<String> path) {
        if (end) return;

        if (depth == tickets.length) {
            answer = path.toArray(new String[0]);
            end = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!isUsed[i]) {
                if (tickets[i][0].equals(cur)) {
                    isUsed[i] = true;
                    path.add(tickets[i][1]);
                    dfs(tickets[i][1], depth + 1, tickets, path);
                    isUsed[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public String[] solution(String[][] tickets) {
        List<String> path = new ArrayList<>();
        path.add("ICN");
        isUsed = new boolean[tickets.length];

        Arrays.sort(tickets, Comparator.comparing(t -> t[1]));

        dfs("ICN", 0, tickets, path);

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();

        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        System.out.println(Arrays.toString(M.solution(tickets)));
    }
}

