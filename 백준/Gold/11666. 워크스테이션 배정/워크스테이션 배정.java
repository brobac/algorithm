import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] time = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;

        researcher:
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty()) {
                if (time[i][0] < pq.peek()) break;
                int t = pq.poll();
                if (time[i][0] <= t + m) {
                    result++;
                    pq.offer(time[i][0] + time[i][1]);
                    continue researcher;
                }
            }
            pq.offer(time[i][0] + time[i][1]);
        }

        System.out.println(result);
    }
}