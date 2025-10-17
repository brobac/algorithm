import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] edges = new int[M][2];
        boolean[] blocked = new boolean[N + 2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            blocked[Integer.parseInt(st.nextToken())] = true;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= N + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (blocked[u] || blocked[v]) continue;
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[N + 2];
        int result = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int adj : adjList.get(cur)) {
                if (visited[adj]) continue;
                result++;
                visited[adj] = true;
                q.offer(adj);
            }
        }

        System.out.println(result);

    }
}