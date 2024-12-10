import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
        }
        ArrayList<Integer> result = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{X, 0});

        boolean[] visited = new boolean[N + 1];
        visited[X] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int city = cur[0];
            int distance = cur[1];

            if (distance == K) {
                result.add(city);
                continue;
            }


            for (int adj : adjList[city]) {
                if (visited[adj]) continue;
                visited[adj] = true;
                q.offer(new int[]{adj, distance + 1});
            }
        }

        if (result.size() == 0) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            Collections.sort(result);
            for (int v : result) {
                sb.append(v).append("\n");
            }
            System.out.print(sb);
        }
    }
}