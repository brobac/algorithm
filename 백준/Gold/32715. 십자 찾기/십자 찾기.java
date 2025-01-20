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
        int K = Integer.parseInt(br.readLine());

        int[][] map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] rowSum = new int[N + 1][M + 1];
        int[][] colSum = new int[N + 1][M + 1];

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                rowSum[r][c] = rowSum[r - 1][c] + map[r - 1][c - 1];
                colSum[r][c] = colSum[r][c - 1] + map[r - 1][c - 1];
            }
        }
        final int LINE_SUM = 2 * K + 1;
        int result = 0;
        for (int r = LINE_SUM; r <= N; r++) {
            for (int c = LINE_SUM; c <= M; c++) {
                int col = colSum[r - K][c] - colSum[r - K][c - LINE_SUM];
                int row = rowSum[r][c - K] - rowSum[r - LINE_SUM][c - K];
                if (col == LINE_SUM && row == LINE_SUM) result++;
            }
        }

        System.out.println(result);
    }
}