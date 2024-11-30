import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int Q, N, M, s;
    static ArrayList<int[]>[] adjList;
    static PriorityQueue<Product> bestQ;
    static boolean[] canceled;
    static int[] minCost;


    static void calculate() {
        minCost = new int[N];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[s] = 0;
        boolean[] visited = new boolean[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{s, 0});
        while (!pq.isEmpty()) {
            int city = pq.poll()[0];

            if (visited[city]) continue;
            visited[city] = true;

            for (int[] adj : adjList[city]) {
                int adjCity = adj[0];
                int adjCost = adj[1];
                if (minCost[city] + adjCost < minCost[adjCity]) {
                    minCost[adjCity] = minCost[city] + adjCost;
                    pq.offer(new int[]{adjCity, minCost[adjCity]});
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        s = 0;
        bestQ = new PriorityQueue<>();

        Q = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        canceled = new boolean[30001];

        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[a].add(new int[]{b, w});
            adjList[b].add(new int[]{a, w});

        }
        calculate();
//        for (int i = 0; i < N; i++) {
//            System.out.println(i + "번 도시 인접");
//            for (int[] adj : adjList[i]) {
//                System.out.println(Arrays.toString(adj));
//            }
//        }

        query:
        for (int i = 1; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int instruction = Integer.parseInt(st.nextToken());

            if (instruction == 200) {
                int id = Integer.parseInt(st.nextToken());
                int revenue = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                int gain = revenue - minCost[dest];

                Product p = new Product(id, revenue, dest, gain);
//                System.out.println("상품추가 :" + p);
                bestQ.offer(p);

                continue;
            }

            if (instruction == 300) {
                int id = Integer.parseInt(st.nextToken());
                canceled[id] = true;
                continue;
            }

            if (instruction == 400) {
//                System.out.println(Arrays.toString(minCost));
                if (bestQ.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }
                while (!bestQ.isEmpty()) {
                    Product p = bestQ.peek();
                    if (p.gain < 0) {
                        sb.append("-1\n");
                        continue query;
                    }
                    p = bestQ.poll();
                    if (!canceled[p.id]) {
                        sb.append(p.id).append("\n");
                        continue query;
                    }
                }
                sb.append("-1\n");
                continue;
            }
            if (instruction == 500) {
                s = Integer.parseInt(st.nextToken());
                calculate();
//                System.out.println("재계산");
//                System.out.println(Arrays.toString(minCost));
                List<Product> list = new ArrayList<>();
                while (!bestQ.isEmpty()) {
                    list.add(bestQ.poll());
                }
                for (Product p : list) {
                    p.gain = p.revenue - minCost[p.dest];
//                    System.out.println(p);
                    bestQ.offer(p);
                }
            }

        }
        System.out.println(sb);
    }

    static class Product implements Comparable<Product> {
        int id, revenue, dest, gain;

        public Product(int id, int revenue, int dest, int gain) {
            this.id = id;
            this.revenue = revenue;
            this.dest = dest;
            this.gain = gain;
        }

        @Override
        public int compareTo(Product o) {
            if (gain == o.gain) return id - o.id;
            return Integer.compare(o.gain, gain);
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", revenue=" + revenue +
                    ", dest=" + dest +
                    ", gain=" + gain +
                    '}';
        }
    }
}
