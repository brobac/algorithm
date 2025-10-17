import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] dp;
    static boolean[] visited;
    static List<List<Integer>> adjList = new ArrayList<>();

    static void dfs(int n) {
        visited[n] = true;

        dp[n][0] = 0;
        dp[n][1] = 1;

        for (int adj : adjList.get(n)) {
            if (visited[adj]) continue;

            dfs(adj);

            dp[n][0] += dp[adj][1];
            dp[n][1] += Math.min(dp[adj][0], dp[adj][1]);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }


        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));


    }
}