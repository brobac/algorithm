import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        testCase:
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<Integer>[] adjList = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adjList[u].add(v);
                adjList[v].add(u);
            }

            int[] visited = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                if (visited[i] != 0) continue;
                visited[i] = 1;
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{i, 1});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int v = cur[0];
                    int set = cur[1];

                    int nextSet = set == 1 ? 2 : 1;

                    for (int adj : adjList[v]) {
                        if (visited[adj] == set) {
                            result.append("NO\n");
                            continue testCase;
                        }
                        if (visited[adj] == nextSet) continue;
                        
                        visited[adj] = nextSet;
                        q.offer(new int[]{adj, nextSet});
                    }
                }
            }

            result.append("YES\n");
        }
        System.out.println(result);
    }

}