import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] snow = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
        }

        int result = 1;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0];
            int t = cur[1];
            int sum = cur[2];

            if (t == M) break;


            if (idx + 1 <= N) {
                int next = sum + snow[idx + 1];
                result = Math.max(result, next);
                q.offer(new int[]{idx + 1, t + 1, next});
            }

            if (idx + 2 <= N) {
                int next = sum / 2 + snow[idx + 2];
                result = Math.max(result, next);
                q.offer(new int[]{idx + 2, t + 1, next});
            }

        }

        System.out.println(result);
    }
}