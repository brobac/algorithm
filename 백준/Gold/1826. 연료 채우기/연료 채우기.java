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
        int N = Integer.parseInt(br.readLine());

        int[][] stations = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stations[i][0] = Integer.parseInt(st.nextToken());
            stations[i][1] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(stations, Comparator.comparingInt(a -> a[0]));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int move = 0;

        int stop = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] station : stations) {
            int curMove = station[0] - move;

            if (P < curMove) {
                while (!pq.isEmpty() && P < curMove) {
                    P += pq.poll();
                    stop++;
                }

                if (P < curMove) {
                    System.out.println(-1);
                    return;
                }
            }
            pq.offer(station[1]);
            P -= curMove;
            move = station[0];
        }

        int remain = L - move;
        while (!pq.isEmpty() && P < remain) {
            P += pq.poll();
            stop++;
        }
        if (P < remain) {
            System.out.println(-1);
            return;
        }

        System.out.println(stop);

    }
}