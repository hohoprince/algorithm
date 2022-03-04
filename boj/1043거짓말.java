import java.util.*;

public class Main {

    static int[] parents;

    public static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        Set<Integer> know = new HashSet<>();
        List<List<Integer>> partyList = new ArrayList<>();

        // 진실을 아는 사람
        int i = sc.nextInt();
        for (int j = 0; j < i; j++) {
            know.add(sc.nextInt());
        }

        for (int j = 0; j < m; j++) {
            int k = sc.nextInt();
            List<Integer> party = new ArrayList<>();

            // 파티원 입력
            for (int l = 0; l < k; l++) {
                party.add(sc.nextInt());
            }
            partyList.add(party);

            // 파티원 union
            for (int l = 1; l < k; l++) {
                union(party.get(0), party.get(l));
            }
        }

        Set<Integer> newSet = new HashSet<>();

        for (int x : know) {
            newSet.add(find(x));
        }

        int count = 0;
        for (List<Integer> party : partyList) {
            boolean all = true;
            for (Integer person : party) {
                if (newSet.contains(find(person))) {
                    all = false;
                    break;
                }
            }
            if (all) {
                count++;
            }
        }

        System.out.println(count);
    }
}
