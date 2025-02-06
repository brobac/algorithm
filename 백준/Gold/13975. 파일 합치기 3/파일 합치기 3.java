import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> q = new PriorityQueue<>();

            for (int k = 0; k < K; k++) {
                q.offer(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while (1 < q.size()) {
                long file = q.poll() + q.poll();
                sum += file;
                q.offer(file);
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}