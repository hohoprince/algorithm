import java.util.*;

class Candidate implements Comparable<Candidate> {
    int height;
    int weight;

    public Candidate(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Candidate o) {
        return Integer.compare(o.height, this.height);
    }
}

public class Main {

    int solution(int n, Candidate[] candidates) {
        int count = 0;

        Arrays.sort(candidates);
        int maxWeight = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (maxWeight < candidates[i].weight) {
                count++;
                maxWeight = candidates[i].weight;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {
            candidates[i] = new Candidate(sc.nextInt(), sc.nextInt());
        }

        System.out.println(T.solution(n, candidates));
    }
}

