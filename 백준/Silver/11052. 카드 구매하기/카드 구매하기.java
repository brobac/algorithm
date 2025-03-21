import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int P = Integer.parseInt(st.nextToken());
            for (int j = i; j <= N; j++) {
                dp[j] = Math.max(dp[j], P + dp[j - i]);
            }
        }
        System.out.println(dp[N]);
    }
}