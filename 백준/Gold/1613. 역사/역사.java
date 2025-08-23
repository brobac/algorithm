import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] isPrior = new boolean[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            isPrior[a][b] = true;
        }


        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isPrior[i][k] && isPrior[k][j]) {
                        isPrior[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int s = Integer.parseInt(br.readLine());
        for (; 0 < s; s--) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (!isPrior[a][b] && !isPrior[b][a]) {
                sb.append("0\n");
            } else if (isPrior[a][b]) {
                sb.append("-1\n");
            } else {
                sb.append("1\n");
            }
        }

        System.out.println(sb);
    }
}
