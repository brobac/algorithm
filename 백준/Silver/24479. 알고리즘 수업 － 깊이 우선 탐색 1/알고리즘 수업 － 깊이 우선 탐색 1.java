import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Integer>[] q;
    static int[] visited;
    static int t = 1;

    static void dfs(int n) {
        visited[n] = t++;
        while (!q[n].isEmpty()) {
            int adj = q[n].poll();
            if (visited[adj] != 0) continue;
            dfs(adj);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        q = new PriorityQueue[N + 1];
        for (int i = 1; i <= N; i++) {
            q[i] = new PriorityQueue<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            q[a].offer(b);
            q[b].offer(a);
        }

        visited = new int[N + 1];
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }
}