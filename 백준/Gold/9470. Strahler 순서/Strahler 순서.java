import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int[] order = new int[M + 1];
            int[] inCount = new int[M + 1];
            int[] maxOrder = new int[M + 1];
            int[] maxCount = new int[M + 1];

            ArrayList<Integer>[] adjList = new ArrayList[M + 1];
            for (int i = 1; i <= M; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                adjList[A].add(B);
                inCount[B]++;
            }

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= M; i++) {
                if (inCount[i] == 0) {
                    q.offer(i);
                    order[i] = 1;
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                if (maxCount[cur] == 1) {
                    order[cur] = maxOrder[cur];
                } else if (maxCount[cur] >= 2) {
                    order[cur] = maxOrder[cur] + 1;
                } else {
                    order[cur] = 1;
                }

                for (int adj : adjList[cur]) {
                    if (order[cur] > maxOrder[adj]) {
                        maxOrder[adj] = order[cur];
                        maxCount[adj] = 1;
                    } else if (order[cur] == maxOrder[adj]) {
                        maxCount[adj]++;
                    }
                    inCount[adj]--;

                    if (inCount[adj] == 0) {
                        q.offer(adj);
                    }
                }
            }


            sb.append(K).append(" ").append(order[M]).append("\n");
        }

        System.out.println(sb);
    }
}