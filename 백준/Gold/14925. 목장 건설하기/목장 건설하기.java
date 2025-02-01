import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());


        int result = 0;

        int[][] dp = new int[M + 1][N + 1];

        for (int r = 1; r <= M; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                if (Integer.parseInt(st.nextToken()) != 0) continue;

                dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1])) + 1;

                result = Math.max(result, dp[r][c]);
            }
        }

        System.out.println(result);
    }
}