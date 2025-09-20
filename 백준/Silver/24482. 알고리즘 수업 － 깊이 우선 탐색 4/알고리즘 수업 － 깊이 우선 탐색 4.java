import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] depth;

    static void dfs(int n, int d) {
        depth[n] = d;
        adjList.get(n).sort((a, b) -> b - a);

        for (int adj : adjList.get(n)) {
            if (depth[adj] != -1) continue;
            dfs(adj, d + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            adjList.get(b).add(a);

        }

        depth = new int[N + 1];
        Arrays.fill(depth, -1);

        dfs(R, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(depth[i]).append("\n");
        }

        System.out.println(sb);

    }
}
