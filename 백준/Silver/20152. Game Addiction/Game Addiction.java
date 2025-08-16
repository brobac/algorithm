import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        if (H == N) {
            System.out.println(1);
            return;
        }

        int K = Math.abs(H - N);

        long[][] dp = new long[K + 2][K + 2];

        dp[1][1] = 1;

        for (int i = 2; i <= K + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        System.out.println(dp[K + 1][K + 1]);
    }
}