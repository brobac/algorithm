import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long score = 0;
        int result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            pq.offer(x);
            score += x;
            if (M <= score) {
                int max = pq.poll();
                score -= max * 2;
                result++;
            }
        }
        System.out.println(result);
    }
}