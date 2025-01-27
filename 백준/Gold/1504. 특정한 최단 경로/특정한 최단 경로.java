import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());


        ArrayList<Edge>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Edge(b, c));
            adjList[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());


        int[] starts = new int[3];
        starts[0] = 1;
        starts[1] = Integer.parseInt(st.nextToken());
        starts[2] = Integer.parseInt(st.nextToken());


        int[][] minCost = new int[3][N + 1];
        for (int[] mc : minCost) {
            Arrays.fill(mc, 10000000);
        }

        for (int i = 0; i < 3; i++) {
            minCost[i][starts[i]] = 0;
        }


        for (int i = 0; i < 3; i++) {
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[N + 1];
            pq.offer(new Edge(starts[i], 0));
            while (!pq.isEmpty()) {
                Edge cur = pq.poll();

                if (visited[cur.v]) continue;
                visited[cur.v] = true;

                for (Edge e : adjList[cur.v]) {
                    int newCost = minCost[i][cur.v] + e.cost;
                    if (newCost < minCost[i][e.v]) {
                        minCost[i][e.v] = newCost;
                        pq.offer(new Edge(e.v, newCost));
                    }
                }
            }
        }

        int result = Math.min(minCost[0][starts[1]] + minCost[1][starts[2]] + minCost[2][N], minCost[0][starts[2]] + minCost[2][starts[1]] + minCost[1][N]);

        System.out.println(result < 10000000 ? result : -1);


    }

    static class Edge implements Comparable<Edge> {
        int v, cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
}