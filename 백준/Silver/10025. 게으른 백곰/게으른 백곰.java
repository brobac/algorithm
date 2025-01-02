import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] ice = new int[MAX];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            ice[x] = g;
        }
        int[] dp = new int[MAX];
        dp[0] = ice[0];
        for (int i = 1; i < MAX; i++) {
            dp[i] = dp[i - 1] + ice[i];
        }
        if (500000 <= K) {
            System.out.println(dp[MAX - 1]);
            return;
        }
        int result = dp[2 * K];
        for (int i = 2 * K + 1; i < MAX - K; i++) {
            int sum = dp[i] - dp[i - 2 * K - 1];
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}