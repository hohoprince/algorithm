import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportCountMap = new HashMap<>();
        Map<String, List<String>> reportMap = new HashMap<>();

        for (String id : id_list) {
            reportCountMap.put(id, 0);
            reportMap.put(id, new ArrayList<>());
        }

        for (String receipt : report) {
            String[] splitReceipt = receipt.split(" ");
            String p1 = splitReceipt[0];
            String p2 = splitReceipt[1];

            if (!reportMap.get(p1).contains(p2)) {
                List<String> li = reportMap.get(p1);
                li.add(p2);
                reportMap.put(p1, li);

                Integer count = reportCountMap.get(p2) + 1;
                reportCountMap.put(p2, count);
            }
        }

        List<String> stopIds = new ArrayList<>();

        for (String key : reportCountMap.keySet()) {
            int count = reportCountMap.get(key);
            if (count >= k) {
                stopIds.add(key);
            }
        }

        int[] answer = new int[id_list.length];
        Arrays.fill(answer, 0);

        for (int i = 0; i < id_list.length; i++) {
            List<String> reportList = reportMap.get(id_list[i]);
            for (String name : reportList) {
                if (stopIds.contains(name)) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}
