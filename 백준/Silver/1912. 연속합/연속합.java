import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[N + 1];
        int[] dp = new int[N + 1];

        int result = -1001;
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            result = Math.max(result, num[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (0 < dp[i - 1] + num[i]) {
                dp[i] = dp[i - 1] + num[i];
                result = Math.max(result, dp[i]);
            }
        }


        System.out.println(result);
    }
}