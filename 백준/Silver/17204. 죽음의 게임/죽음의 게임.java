import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] next = new int[N];
        for (int i = 0; i < N; i++) {
            next[i] = Integer.parseInt(br.readLine());
        }
        int count = 1;
        int cur = next[0];
        boolean[] visited = new boolean[N];
        visited[0] = true;
        while (cur != K) {
            if (visited[next[cur]]) {
                System.out.println(-1);
                return;
            }
            cur = next[cur];
            visited[cur] = true;
            count++;
        }

        System.out.println(count);
    }
}