import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            ArrayList<int[]>[] adjList = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                adjList[b].add(new int[]{a, s});
            }

            int[] time = new int[N + 1];
            Arrays.fill(time, Integer.MAX_VALUE);
            time[C] = 0;
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{C, 0});
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int[] adj : adjList[cur[0]]) {
                    int nt = cur[1] + adj[1];
                    if (nt < time[adj[0]]) {
                        time[adj[0]] = nt;
                        q.offer(new int[]{adj[0], nt});
                    }

                }

            }

            int count = 0;
            int lastTime = 0;
            for (int i = 1; i <= N; i++) {
                if (time[i] == Integer.MAX_VALUE) continue;
                count++;
                lastTime = Math.max(lastTime, time[i]);

            }

            sb.append(count).append(" ").append(lastTime).append("\n");


        }


        System.out.println(sb);

    }
}