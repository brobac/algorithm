import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            int t = A[i] - A[i - 1];
            sum += t;
            if (pq.size() < K) {
                pq.offer(t);
            } else if (!pq.isEmpty() && pq.peek() < t) {
                pq.poll();
                pq.offer(t);
            }
        }

        while (!pq.isEmpty()) {
            sum -= pq.poll();
        }

        System.out.println(sum);

    }
}
