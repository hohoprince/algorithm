import java.util.*;

class Thing {
    int weight;
    int value;

    public Thing(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Main {

    static int solution(int n, int k, List<Thing> arr) {
        int[] maxWeights = new int[k + 1];

        arr.sort(Comparator.comparingInt(t -> t.weight));

        for (Thing currentThing : arr) {
            for (int i = k; i >= 0; i--) {
                if (i - currentThing.weight >= 0
                        && maxWeights[i - currentThing.weight] + currentThing.value > maxWeights[i]) {
                    maxWeights[i] = maxWeights[i - currentThing.weight] + currentThing.value;
                }
            }
        }

        return maxWeights[k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Thing> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new Thing(sc.nextInt(), sc.nextInt()));
        }

        System.out.println(solution(n, k, arr));

    }
}
