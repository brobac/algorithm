import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[100];
        int N = Integer.parseInt(br.readLine());

        StringTokenizer hpTokenizer = new StringTokenizer(br.readLine());
        StringTokenizer joyTokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int hp = Integer.parseInt(hpTokenizer.nextToken());
            int joy = Integer.parseInt(joyTokenizer.nextToken());

            for (int j = 99; 0 <= j - hp; j--) {
                dp[j] = Math.max(dp[j], dp[j - hp] + joy);
            }
        }
        System.out.println(dp[99]);
    }
}