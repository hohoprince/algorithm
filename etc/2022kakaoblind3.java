import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    public int getTime(String inTime, String outTime) {
        String[] inSplitTime = inTime.split(":");
        int inHour = Integer.parseInt(inSplitTime[0]);
        int inMinute = Integer.parseInt(inSplitTime[1]);

        String[] outSplitTime = outTime.split(":");
        int outHour = Integer.parseInt(outSplitTime[0]);
        int outMinute = Integer.parseInt(outSplitTime[1]);

        return (outHour * 60 + outMinute) - (inHour * 60 + inMinute);
    }
    
    public List<Integer> solution(int[] fees, String[] records) {
        
        
        Map<String, Integer> accumulateTimeMap = new HashMap<>();
        Map<String, String> inTimeMap = new HashMap<>();

        for (String record : records) {
            String[] tmp = record.split(" ");
            String time = tmp[0];
            String carNumber = tmp[1];
            String action = tmp[2];

            if (!accumulateTimeMap.containsKey(carNumber)) {
                accumulateTimeMap.put(carNumber, 0);
            }

            if (action.equals("IN")) {
                inTimeMap.put(carNumber, time);
            } else {
                String inTime = inTimeMap.get(carNumber);
                inTimeMap.remove(carNumber);
                int diffTime = getTime(inTime, time);
                accumulateTimeMap.put(carNumber, accumulateTimeMap.get(carNumber) + diffTime);
            }
        }

        for (String leftCarNumber : inTimeMap.keySet()) {
            String inTime = inTimeMap.get(leftCarNumber);
            int diffTime = getTime(inTime, "23:59");
            accumulateTimeMap.put(leftCarNumber, accumulateTimeMap.get(leftCarNumber) + diffTime);
        }

        List<String> sortedKeys = accumulateTimeMap.keySet().stream().sorted().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();

        sortedKeys.forEach(key -> {
            int finalTime = accumulateTimeMap.get(key);

            if (finalTime > fees[0]) {
                result.add(fees[1] + ((int) Math.ceil((float) (finalTime - fees[0]) / fees[2])) * fees[3]);
            } else {
                result.add(fees[1]);
            }
        });

        
        return result;
    }
}
