import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{S, T, 0});
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int a = cur[0];
                int b = cur[1];
                int count = cur[2];

                if (a == b) {
                    sb.append(count).append("\n");
                    break;
                }

                if (a * 2 <= b + 3) {
                    q.offer(new int[]{a * 2, b + 3, count + 1});
                }

                if (a + 1 <= b) {
                    q.offer(new int[]{a + 1, b, count + 1});
                }


            }

        }
        System.out.println(sb);

    }
}