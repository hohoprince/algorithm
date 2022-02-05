import java.util.*;

class Case {
    int start;
    int end;

    public Case(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Job {
    int num;
    String command;

    public Job(int num, String command) {
        this.num = num;
        this.command = command;
    }

    public int process(char x) {
        if (x == 'D') {
            return d(num);
        } else if (x == 'S') {
            return s(num);
        } else if (x == 'L') {
            return l(num);
        } else if (x == 'R'){
            return r(num);
        }

        return num;
    }

    int d(int num) {
        return (2 * num) % 10000;
    }

    int s(int num) {
        return num == 0 ? 9999 : num - 1;
    }

    int l(int num) {
        return num % 1000 * 10 + num / 1000;
    }

    int r(int num) {
        return num / 10 + num % 10 * 1000;
    }
}

public class Main {

    static char[] methods = {'D', 'S', 'L', 'R'};

    static String bfs(int num, int end) {
        Queue<Job> jobQueue = new LinkedList<>();
        boolean[] check = new boolean[10000];

        jobQueue.offer(new Job(num, ""));

        while (!jobQueue.isEmpty()) {
            Job curJob = jobQueue.poll();
            if (curJob.num == end) {
                return curJob.command;
            }

            for (char method : methods) {
                int processed = curJob.process(method);
                if (!check[processed]) {
                    check[processed] = true;
                    jobQueue.offer(new Job(processed, curJob.command + method));
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Case> cases = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cases.add(new Case(sc.nextInt(), sc.nextInt()));
        }

        List<String> answers = new ArrayList<>();
        cases.forEach(c -> answers.add(bfs(c.start, c.end)));

        answers.forEach(System.out::println);

    }
}
