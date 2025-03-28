import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] h;
    static int[] count;
    static ArrayList<Integer>[] adjList;

    static void solution(int n) {
        int result = 1;
        int max = 0;
        for (int adj : adjList[n]) {
            if (count[adj] == 0) solution(adj);
            max = Math.max(max, count[adj]);
        }

        result += max;

        count[n] = result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        h = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] connected = new boolean[N + 1][N + 1];
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (connected[a][b] || connected[b][a]) continue;
            connected[a][b] = true;
            connected[b][a] = true;
            if (h[a] < h[b]) {
                adjList[a].add(b);
            } else {
                adjList[b].add(a);
            }
        }

        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (count[i] != 0) continue;
            solution(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(count[i]).append("\n");
        }
        System.out.print(sb);
    }
}