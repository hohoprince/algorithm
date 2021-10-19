import java.util.*;

class Combination {
    private int n;
    private int r;
    private int[] now;
    private List<List<Character>> result;

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<>();
    }

    public List<List<Character>> getResult() {
        return result;
    }

    public void combination(char[] arr, int depth, int index, int target) {
        if (depth == r) {
            List<Character> temp = new ArrayList<>();
            for (int num : now) {
                temp.add(arr[num]);
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

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (int num : course) {
            Map<String, Integer> map = new HashMap<>();

            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                order = new String(chars);
                Combination comb = new Combination(order.length(), num);
                comb.combination(order.toCharArray(), 0, 0, 0);
                List<List<Character>> combinations = comb.getResult();

                for (List<Character> combination : combinations) {
                    if (combination.isEmpty()) continue;

                    StringBuilder sb = new StringBuilder();
                    for (char c : combination) {
                        sb.append(c);
                    }

                    String str = sb.toString();
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }

            int maxValue = 0;
            for (int value : map.values()) {
                maxValue = Math.max(value, maxValue);
            }

            if (maxValue < 2) continue;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxValue) {
                    result.add(entry.getKey());
                }
            }

        }

        result.sort(String::compareTo);
        String[] resultArray = new String[result.size()];
        resultArray = result.toArray(resultArray);
        
        return resultArray;
    }
}
