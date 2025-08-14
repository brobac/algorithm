import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (; 0 < T; T--) {
            int N = Integer.parseInt(br.readLine());
            int[] next = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                next[i] = Integer.parseInt(br.readLine());
            }

            boolean[] visited = new boolean[N + 1];
            visited[1] = true;
            int cur = 1;
            int count = 0;
            while (true) {
                count++;
                if (visited[next[cur]]) {
                    sb.append("0\n");
                    break;
                }

                if (next[cur] == N) {
                    sb.append(count).append("\n");
                    break;
                }
                cur = next[cur];
                visited[cur] = true;
            }
        }
        System.out.println(sb);
    }
}