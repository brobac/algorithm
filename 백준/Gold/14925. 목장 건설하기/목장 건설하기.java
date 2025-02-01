import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[M + 1][N + 1];

        for (int r = 1; r <= M; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = new int[M + 1][N + 1];
        for (int r = 1; r <= M; r++) {
            for (int c = 1; c <= N; c++) {
                sum[r][c] = map[r][c] + sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1];
            }
        }

        for (int l = Math.min(M, N); 0 < l; l--) {
            for (int r = 0; r <= M - l; r++) {
                for (int c = 0; c <= N - l; c++) {
                    if (sum[r + l][c + l] - sum[r + l][c] - sum[r][c + l] + sum[r][c] == 0) {
                        System.out.println(l);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
}