import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static List<int[]>[] adjList;


    static int[] dfs(int start) {
        int[] result = new int[2];
        boolean[] visited = new boolean[V + 1];
        visited[start] = true;

        for (int[] adj : adjList[start]) {
            if (visited[adj[0]]) continue;
            dfs(adj[0], visited, adj[1], result);
        }

        return result;
    }

    static void dfs(int v, boolean[] visited, int distance, int[] result) {
        visited[v] = true;
        if (result[1] < distance) {
            result[0] = v;
            result[1] = distance;
        }
        for (int[] adj : adjList[v]) {
            if (visited[adj[0]]) continue;
            dfs(adj[0], visited, distance + adj[1], result);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        adjList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int adj;
            while ((adj = Integer.parseInt(st.nextToken())) != -1) {
                int distance = Integer.parseInt(st.nextToken());
                adjList[v].add(new int[]{adj, distance});
                adjList[adj].add(new int[]{v, distance});
            }
        }

        int[] u = dfs(1);
        int[] v = dfs(u[0]);
        System.out.println(v[1]);

    }
}