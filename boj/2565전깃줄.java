import java.util.*;

class Line {
    int left;
    int right;

    public Line(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Line{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}

public class Main {

    static int solution(int n, List<Line> lines) {
        lines.sort(Comparator.comparingInt(l -> l.left));
        int[] nums = new int[lines.size()];
        int[] counts = new int[lines.size()];

        Arrays.fill(counts, 1);

        for (int i = 0; i < lines.size(); i++) {
            nums[i] = lines.get(i).right;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    counts[i] = Math.max(counts[i], counts[j] + 1);
                }
            }
        }

        int maxCount = Integer.MIN_VALUE;
        for (int count : counts) {
            maxCount = Math.max(maxCount, count);
        }

        return n - maxCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lines.add(new Line(sc.nextInt(), sc.nextInt()));
        }

        System.out.println(solution(n, lines));
    }
}
