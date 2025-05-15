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
        int[][] card = new int[N][2];
        int[] face = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            card[i][0] = Integer.parseInt(st.nextToken());
            card[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            int K = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                if (card[j][face[j]] <= K) {
                    face[j] = face[j] == 0 ? 1 : 0;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += card[i][face[i]];
        }

        System.out.println(result);
    }
}