import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[33334];
        dp[1] = 0;
        dp[2] = 2;
        for (int i = 3; i <= 33333; i++) {
            dp[i] = dp[i - 1] * 3 % 1000000009;
        }
        System.out.println(dp[N]);
    }
}
