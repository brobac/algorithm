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

        int[][] map = new int[N + 1][N + 1];
        long[][] sum = new long[N + 2][N + 2];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int sr = Integer.parseInt(st.nextToken()) + 1;
            int sc = Integer.parseInt(st.nextToken()) + 1;
            int er = Integer.parseInt(st.nextToken()) + 1;
            int ec = Integer.parseInt(st.nextToken()) + 1;
            int k = Integer.parseInt(st.nextToken());

            sum[sr][sc] += k;
            sum[er + 1][sc] -= k;
            sum[sr][ec + 1] -= k;
            sum[er + 1][ec + 1] += k;
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                sum[r][c] = sum[r][c] + sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1];
            }
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int sr = Integer.parseInt(st.nextToken()) + 1;
        int sc = Integer.parseInt(st.nextToken()) + 1;
        int er = Integer.parseInt(st.nextToken()) + 1;
        int ec = Integer.parseInt(st.nextToken()) + 1;

        long result = 0;
        for (int r = sr; r <= er; r++) {
            for (int c = sc; c <= ec; c++) {
                result += map[r][c] + sum[r][c];
            }
        }

        System.out.println(result);
    }
}