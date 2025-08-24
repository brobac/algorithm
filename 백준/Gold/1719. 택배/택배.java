import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int NO_PATH = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] d = new int[N + 1][N + 1];
        int[][] firstStation = new int[N + 1][N + 1];

        for (int r = 0; r <= N; r++) {
            for (int c = 0; c <= N; c++) {
                d[r][c] = NO_PATH;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (d[a][b] == NO_PATH) {
                d[a][b] = c;
                d[b][a] = c;
            } else {
                d[a][b] = Math.min(d[a][b], c);
                d[b][a] = Math.min(d[b][a], c);
            }
            firstStation[a][b] = b;
            firstStation[b][a] = a;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    int via = d[i][k] + d[k][j];
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = via;
                        firstStation[i][j] = firstStation[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    sb.append("- ");
                } else {
                    sb.append(firstStation[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}