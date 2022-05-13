import java.util.*;

public class Main {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            indexMap.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int income = amount[i] * 100;

            while (true) {
                int rest = income / 10;
                answer[indexMap.get(name)] += income - rest;

                if (rest == 0) {
                    break;
                }

                String parentName = parentMap.get(name);
                if (!parentName.equals("-")) {
                    name = parentName;
                    income = rest;
                } else {
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.toString(M.solution(enroll, referral, seller, amount)));
    }
}

