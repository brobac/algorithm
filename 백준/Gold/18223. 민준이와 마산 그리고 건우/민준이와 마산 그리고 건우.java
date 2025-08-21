import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<List<Edge>> adjList = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Edge(b, c));
            adjList.get(b).add(new Edge(a, c));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] d1 = new int[V + 1];
        Arrays.fill(d1, Integer.MAX_VALUE);
        d1[1] = 0;
        pq.offer(new Edge(1, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            int a = cur.to;
            int c = cur.weight;

            for (Edge e : adjList.get(a)) {
                if (c + e.weight < d1[e.to]) {
                    d1[e.to] = c + e.weight;
                    pq.offer(new Edge(e.to, d1[e.to]));
                }
            }
        }

        int[] d2 = new int[V + 1];
        Arrays.fill(d2, Integer.MAX_VALUE);
        d2[P] = 0;
        pq.offer(new Edge(P, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            int a = cur.to;
            int c = cur.weight;

            for (Edge e : adjList.get(a)) {
                if (c + e.weight < d2[e.to]) {
                    d2[e.to] = c + e.weight;
                    pq.offer(new Edge(e.to, d2[e.to]));
                }
            }
        }

        System.out.println(d1[P] + d2[V] == d1[V] ? "SAVE HIM" : "GOOD BYE");


    }

    static class Edge implements Comparable<Edge> {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(o.weight, weight);
        }
    }
}