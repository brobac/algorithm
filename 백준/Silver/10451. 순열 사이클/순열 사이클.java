import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] p = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            boolean[] visited = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;
                count++;
                int cur = i;
                while (p[cur] != i) {
                    visited[p[cur]] = true;
                    cur = p[cur];
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}