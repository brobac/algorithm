import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        while (!pq.isEmpty()) {
            if (2 <= pq.size()) {
                int a = pq.poll();
                int b = pq.poll();

                time += b;
                if (a != b) {
                    pq.offer(a - b);
                }
            } else {
                time += pq.poll();
            }
        }

        System.out.println(1440 < time ? -1 : time);
    }
}