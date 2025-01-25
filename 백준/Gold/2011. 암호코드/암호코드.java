import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = input[i] - '0';
        }

        if (nums[0] == 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[input.length + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < input.length; i++) {
            if (0 < nums[i]) {
                dp[i + 1] = dp[i];
            }
            int n = nums[i - 1] * 10 + nums[i];
            if (10 <= n && n <= 26) {
                dp[i + 1] = (dp[i + 1] + dp[i - 1]) % MOD;
            }
        }
        System.out.println(dp[input.length]);
    }
}