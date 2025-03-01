import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static List<int[]>[] adjList;
    static long result = 0;

    static boolean[] visited;

    static void dfs(int v, long sum) {
        result = Math.max(result, sum);

        for (int[] adj : adjList[v]) {
            if (visited[adj[0]]) continue;
            visited[adj[0]] = true;
            dfs(adj[0], sum + adj[1]);
            visited[adj[0]] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adjList[A].add(new int[]{B, C});
            adjList[B].add(new int[]{A, C});
        }

        visited[1] = true;
        dfs(1, 0);
        System.out.println(result);
    }
}