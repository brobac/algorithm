import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static List<List<Integer>> adjList = new ArrayList<>();
    static long[] t, d;
    static boolean[] visited;
    static int time = 1;

    static void dfs(int n, int depth) {
        d[n] = depth;
        t[n] = time++;
        visited[n] = true;
        adjList.get(n).sort((a, b) -> b - a);
        for (int adj : adjList.get(n)) {
            if (visited[adj]) continue;
            dfs(adj, depth + 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        t = new long[N + 1];
        d = new long[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        dfs(R, 0);

        long result = 0;

        for (int i = 1; i <= N; i++) {
            result += t[i] * d[i];
        }


        System.out.println(result);
    }
}