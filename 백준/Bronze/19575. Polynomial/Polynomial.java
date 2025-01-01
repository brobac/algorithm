import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        long[] memo = new long[n + 1];
        memo[0] = 1;
        for (int i = 1; i <= n; i++) {
            memo[i] = (memo[i - 1] * x) % MOD;
        }
        long result = 0;
        for (int i = n; 0 <= i; i--) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken()) % MOD;
            result += (a * memo[i]) % MOD;
            result %= MOD;
        }

        System.out.println(result);
    }
}