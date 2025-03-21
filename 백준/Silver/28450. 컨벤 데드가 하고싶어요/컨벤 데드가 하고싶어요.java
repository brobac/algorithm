import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] map = new long[N][M];
        long[][] sum = new long[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        sum[0][0] = map[0][0];
        for (int i = 1; i < N; i++) {
            sum[i][0] = map[i][0] + sum[i - 1][0];
        }

        for (int i = 1; i < M; i++) {
            sum[0][i] = map[0][i] + sum[0][i - 1];

        }

        for (int r = 1; r < N; r++) {
            for (int c = 1; c < M; c++) {
                sum[r][c] = map[r][c] + Math.min(sum[r - 1][c], sum[r][c - 1]);
            }
        }

        long H = Integer.parseInt(br.readLine());

        if (H < sum[N - 1][M - 1]) {
            System.out.println("NO");
        } else {
            System.out.println("YES\n" + sum[N - 1][M - 1]);
        }
    }
}