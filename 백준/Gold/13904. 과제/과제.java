import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] job = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            job[i][0] = Integer.parseInt(st.nextToken());
            job[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(job, Comparator.comparingInt(a -> a[0]));

        int day = 0;
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int dueDate = job[i][0];
            int score = job[i][1];

            if (day < dueDate) {
                result += score;
                pq.offer(score);
                day++;
                continue;
            }

            if (!pq.isEmpty() && pq.peek() < score) {
                result -= pq.poll();
                result += score;
                pq.offer(score);
            }
        }

        System.out.println(result);
    }
}