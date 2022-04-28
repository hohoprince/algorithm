import java.util.*;

class Job {
    int requestTime;
    int processTime;

    public Job(int requestTime, int processTime) {
        this.requestTime = requestTime;
        this.processTime = processTime;
    }

    @Override
    public String toString() {
        return "Job{" +
                "requestTime=" + requestTime +
                ", processTime=" + processTime +
                '}';
    }
}

public class Main {

    private int solution(int[][] jobs) {
        List<Job> jobList = new ArrayList<>();

        for (int[] job : jobs) {
            int requestTime = job[0];
            int processTime = job[1];
            jobList.add(new Job(requestTime, processTime));
        }

        jobList.sort((j1, j2) -> { // 요청 들어온 시간이 먼저이면 우선, 같다면 처리시간이 작은순으로 정렬
            if (j1.requestTime == j2.requestTime) {
                return j1.processTime - j2.processTime;
            }
            return j1.requestTime - j2.requestTime;
        });

        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(job -> job.processTime));

        int index = 0;
        int time = 0;
        int sum = 0;

        while (true) {
            if (pq.isEmpty() && index < jobList.size()) { // pq가 빈 큐라면 작업 하나 추가
                Job job = jobList.get(index++);
                pq.offer(job);
                time = job.requestTime;
            }

            if (!pq.isEmpty()) { // 큐가 비지 않았다면 우선순위가 높은 작업을 처리
                Job poll = pq.poll();
                time += poll.processTime;
                sum += time - poll.requestTime;

                // 작업 처리 후 요청 들어온 작업들을 큐에 삽입
                while (index < jobList.size() && time >= jobList.get(index).requestTime) {
                    pq.offer(jobList.get(index++));
                }
            } else {
                break;
            }
        }

        return sum / jobs.length;
    }

    public static void main(String[] args) {
        Main M = new Main();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(M.solution(jobs));
    }
}
