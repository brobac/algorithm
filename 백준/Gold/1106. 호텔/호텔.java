import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int UB = Integer.MAX_VALUE;

        int[] cost = new int[N];
        int[] value = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());

            UB = Math.min(UB, cost[i] * (int) Math.ceil((double) C / value[i]));

        }

        int[] dp = new int[UB + 1];

        for (int i = 0; i < N; i++) {
            for (int c = cost[i]; c <= UB; c++) {
                dp[c] = Math.max(dp[c], dp[c - cost[i]] + value[i]);
            }
        }
        for (int i = UB; 0 <= i; i--) {
            if (dp[i] < C) {
                System.out.println(i + 1);
                return;
            }
        }

    }
}