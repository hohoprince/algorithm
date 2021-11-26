import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<Integer> set = new HashSet<>();

        if (s.contains(",")) {
            String[] parts = s.split(",");
            Map<Integer, Integer> map = new HashMap<>();

            for (String part : parts) {
                part = part.replace("{", "");
                part = part.replace("}", "");
                int number = Integer.parseInt(part);
                map.put(number, map.getOrDefault(number, 0) + 1);
            }
            LinkedList<Integer> keyList = new LinkedList<>(map.keySet());
            keyList.sort((n1, n2) -> {
                return Integer.compare(map.get(n2), map.get(n1));
            });
            return keyList.stream().mapToInt(Integer::intValue).toArray();
        } else {
            String tmp = s.replace("{", "");
            tmp = tmp.replace("}", "");
            int[] answer = new int[] {Integer.parseInt(tmp)};
            return answer;
        }
    }
}
