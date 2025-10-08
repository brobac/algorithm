import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] map = new int[R + 1][C + 1];
        int[][] dp = new int[R + 1][C + 1];

        for (int r = 1; r <= R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]) + map[r][c];
            }
        }

        System.out.println(dp[R][C]);
    }
}