import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int Q, N, M, s;
    static boolean calculated;
    static ArrayList<int[]>[] adjList;
    static PriorityQueue<Product> bestQ;
    static Product[] products;
    static ArrayList<Product> unCalculatedProductList;


    static int getGain(Product p) {

        boolean[] visited = new boolean[N];
        int[] minCost = new int[N + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{s, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int vertex = cur[0];
            int cost = cur[1];

            if (visited[vertex]) continue;
            visited[vertex] = true;

            for (int[] adj : adjList[vertex]) {
                int adjVertex = adj[0];
                int adjCost = adj[1];
                if (adjCost + minCost[vertex] < minCost[adjVertex]) {
                    minCost[adjVertex] = adjCost + minCost[vertex];
                    pq.offer(new int[]{adjVertex, minCost[adjVertex]});
                }
            }
        }

//        System.out.println("id : " + p.id + " gain : " + p.revenue + " - " + minCost[p.dest] + " = " + (p.revenue - minCost[p.dest]));

        if (minCost[p.dest] == Integer.MAX_VALUE || p.revenue - minCost[p.dest] < 0) {
            return -1;
        }

        return p.revenue - minCost[p.dest];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        s = 0;
        calculated = false;
        bestQ = new PriorityQueue<>();
        products = new Product[30001];
        unCalculatedProductList = new ArrayList<>();

        Q = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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
//        for (int i = 0; i < N; i++) {
//            System.out.println(i + "번 도시 인접");
//            for (int[] adj : adjList[i]) {
//                System.out.println(Arrays.toString(adj));
//            }
//        }

        for (int i = 1; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int instruction = Integer.parseInt(st.nextToken());

            if (instruction == 200) {
                int id = Integer.parseInt(st.nextToken());
                int revenue = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                products[id] = new Product(id, revenue, dest);
                unCalculatedProductList.add(products[id]);
                continue;
            }

            if (instruction == 300) {
                int id = Integer.parseInt(st.nextToken());
                if (products[id] != null) {
                    products[id].removed = true;
                    products[id] = null;
                }
                continue;
            }

            if (instruction == 400) {
                if (calculated) {
                    for (Product p : unCalculatedProductList) {
                        p.gain = getGain(p);
                        if (p.gain != -1) {
                            bestQ.offer(p);
                        }
                    }
                    unCalculatedProductList = new ArrayList<>();

                } else {
                    bestQ = new PriorityQueue<>();
                    for (int id = 1; id <= 30000; id++) {
                        if (products[id] == null) continue;
                        products[id].gain = getGain(products[id]);
                        if (products[id].gain != -1) {
                            bestQ.offer(products[id]);
                        }
                    }
                    unCalculatedProductList = new ArrayList<>();
                    calculated = true;
                }

                if (bestQ.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    boolean check = false;
                    while (!bestQ.isEmpty()) {
                        Product p = bestQ.poll();
                        if (p.removed) continue;
                        int id = p.id;
                        products[id] = null;
                        sb.append(id).append("\n");
                        check = true;
                        break;
                    }
                    if (!check) {
                        sb.append("-1\n");
                    }


                }

                continue;
            }
            if (instruction == 500) {
                s = Integer.parseInt(st.nextToken());
                calculated = false;
            }

        }
        System.out.println(sb);
    }

    static class Product implements Comparable<Product> {
        int id, revenue, dest, gain;
        boolean removed;

        public Product(int id, int revenue, int dest) {
            this.id = id;
            this.revenue = revenue;
            this.dest = dest;
            removed = false;
        }

        @Override
        public int compareTo(Product o) {
            if (gain == o.gain) return id - o.id;
            return o.gain - gain;
        }
    }
}
