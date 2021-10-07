import java.util.*;

class MoveInfo {
    String id;
    boolean isIn;

    public MoveInfo(String id, boolean isIn) {
        this.id = id;
        this.isIn = isIn;
    }
}

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        Queue<MoveInfo> moveInfoQueue = new LinkedList<>();

        for (String s : record) {
            String[] strs = s.split(" ");

            if (strs[0].equals("Enter")) {
                map.put(strs[1], strs[2]);
                moveInfoQueue.offer(new MoveInfo(strs[1], true));
            } else if (strs[0].equals("Leave")) {
                moveInfoQueue.offer(new MoveInfo(strs[1], false));
            } else if (strs[0].equals("Change")) {
                map.put(strs[1], strs[2]);
            }

        }

        int count = moveInfoQueue.size();
        String[] answer = new String[count];

        for (int i = 0; i < count; i++) {
            MoveInfo m = moveInfoQueue.poll();
            answer[i] = String.format("%s님이 %s", map.get(m.id), m.isIn ? "들어왔습니다." : "나갔습니다.");
        }
        
        return answer;
    }
}
