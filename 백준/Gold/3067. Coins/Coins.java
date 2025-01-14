import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M + 1];


            dp[0] = 1;
            for (int i = 1; i <= M; i++) {
                if (i % coins[0] == 0) dp[i] = 1;
            }

            for (int i = 1; i < N; i++) {
                for (int j = coins[i]; j <= M; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }

            sb.append(dp[M]).append("\n");
        }

        System.out.println(sb);
    }
}