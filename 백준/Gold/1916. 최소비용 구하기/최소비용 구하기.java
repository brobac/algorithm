import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[a].add(new int[]{b, w});
        }


        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[] d = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{s, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int vertex = cur[0];
            int distance = cur[1];

            if (visited[vertex]) continue;
            visited[vertex] = true;

            for (int[] adj : adjList[vertex]) {
                int adjVertex = adj[0];
                int adjDistance = adj[1];
                if (distance + adjDistance < d[adjVertex]) {
                    d[adjVertex] = distance + adjDistance;
                    pq.offer(new int[]{adjVertex, d[adjVertex]});
                }
            }


        }
        System.out.println(d[e]);

    }
}