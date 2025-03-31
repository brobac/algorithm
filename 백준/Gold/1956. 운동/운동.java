import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] d = new int[V + 1][V + 1];

        final int INF = 100000000;
        for (int i = 1; i <= V; i++) {
            Arrays.fill(d[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            d[a][b] = c;
        }


        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (d[i][k] == INF || d[k][j] == INF) continue;
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            if (d[i][i] == INF) continue;
            result = Math.min(result, d[i][i]);
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}