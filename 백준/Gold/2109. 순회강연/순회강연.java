import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer>[] jobList = new ArrayList[10001];
        for (int i = 1; i <= 10000; i++) {
            jobList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            jobList[d].add(p);
        }

        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int d = 10000; 1 <= d; d--) {
            for (int v : jobList[d]) {
                pq.offer(v);
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }
        System.out.println(result);
    }
}