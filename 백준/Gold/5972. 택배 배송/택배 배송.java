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
        int[] minDistance = new int[N + 1];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[1] = 0;

        ArrayList<int[]>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adjList[A].add(new int[]{B, C});
            adjList[B].add(new int[]{A, C});
        }

        boolean[] visited = new boolean[N + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int v = cur[0];
            int c = cur[1];

            if (visited[v]) continue;
            visited[v] = true;

            for (int[] adj : adjList[v]) {
                int adjV = adj[0];
                int adjC = adj[1];
                if (minDistance[v] + adjC < minDistance[adjV]) {
                    minDistance[adjV] = minDistance[v] + adjC;
                    pq.offer(new int[]{adjV, minDistance[adjV]});
                }
            }
        }


        System.out.println(minDistance[N]);

    }
}
