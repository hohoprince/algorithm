import java.util.*;

class Stage implements Comparable<Stage> {
    private int num;
    private double failRate;

    public Stage(int num, double failRate) {
        this.num = num;
        this.failRate = failRate;
    }

    public int getNum() {
        return num;
    }

    @Override
    public int compareTo(Stage o) {
        if (failRate == o.failRate) {
            return Integer.compare(num, o.num);
        }
        return Double.compare(o.failRate, failRate);
    }
}


class Solution {
    public int[] solution(int N, int[] stages) {
         List<Stage> stageList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int stage : stages) {
            map.put(stage, map.getOrDefault(stage, 0) + 1);
        }

        int clear = stages.length;

        for (int i = 1; i <= N; i++) {
            int count = map.getOrDefault(i, 0);
            
            double failRate = 0;
            if (clear > 0) {
                failRate = (double) count / clear;
            }
            stageList.add(new Stage(i, failRate));
            clear -= count;
        }

        Collections.sort(stageList);

        int[] result = new int[N];

        for (int i = 0; i < stageList.size(); i++) {
            result[i] = stageList.get(i).getNum();
        }
        return result;
    }
}
