import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = i;
        }
        int[] coin = {2, 5, 7};

        for (int c : coin) {
            for (int i = c; i <= N; i++) {
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }

        System.out.println(dp[N]);

    }
}