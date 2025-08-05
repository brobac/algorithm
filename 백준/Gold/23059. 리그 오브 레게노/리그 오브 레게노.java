import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> itemSet = new HashSet<>();
        Map<String, Integer> inCount = new HashMap<>();
        Map<String, ArrayList<String>> adjList = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            itemSet.add(A);
            itemSet.add(B);


            if (!adjList.containsKey(A)) {
                inCount.put(A, 0);
                adjList.put(A, new ArrayList<>());
            }
            if (!adjList.containsKey(B)) {
                inCount.put(B, 0);
                adjList.put(B, new ArrayList<>());
            }

            inCount.put(B, inCount.getOrDefault(B, 0) + 1);
            adjList.get(A).add(B);
        }

        int purchase = 0;

        StringBuilder sb = new StringBuilder();

        PriorityQueue<String> pq = new PriorityQueue<>();
        PriorityQueue<String> nq = new PriorityQueue<>();

        for (Map.Entry<String, Integer> entry : inCount.entrySet()) {
            if (entry.getValue() == 0) {
                pq.offer(entry.getKey());
            }
        }

        while (!pq.isEmpty()) {
            while (!pq.isEmpty()) {
                String itemName = pq.poll();
                purchase++;
                sb.append(itemName).append("\n");

                for (String nextItem : adjList.get(itemName)) {
                    int count = inCount.get(nextItem);
                    if (count == 1) {
                        nq.offer(nextItem);
                    }
                    inCount.put(nextItem, count - 1);
                }
            }
            pq = nq;
            nq = new PriorityQueue<>();
        }


        if (purchase < itemSet.size()) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }

    }

}