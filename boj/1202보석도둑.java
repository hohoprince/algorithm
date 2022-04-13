import java.util.*;

class Jewelry {
    
    int m;
    int v;

    public Jewelry(int m, int v) {
        this.m = m;
        this.v = v;
    }
}

public class Main {

    private static long solution(List<Jewelry> jewelries, List<Integer> bags) {
        long answer = 0;

        jewelries.sort(Comparator.comparingInt(j -> j.m)); // 보석 무게 오름차순
        Collections.sort(bags); // 가방이 담을 수 있는 무게 오름차순

        PriorityQueue<Jewelry> pq = new PriorityQueue<>((j1, j2) -> j2.v - j1.v); // 보석 가치 내림차순

        int index = 0;

        for (Integer bag : bags) {
            while (jewelries.size() > index && bag >= jewelries.get(index).m) { // 가방 무게와 같거나 작은 보석들을 pq에 추가
                pq.offer(jewelries.get(index++));
            }

            if (!pq.isEmpty()) {
                Jewelry poll = pq.poll();
                answer += poll.v;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 보석 수
        int k = sc.nextInt(); // 가방 수

        List<Jewelry> jewelries = new ArrayList<>();
        List<Integer> bags = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int v = sc.nextInt();
            jewelries.add(new Jewelry(m, v));
        }

        for (int i = 0; i < k; i++) {
            int c = sc.nextInt();
            bags.add(c);
        }

        System.out.println(solution(jewelries, bags));
    }
}
