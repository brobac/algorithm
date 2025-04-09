import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long[] K = new long[N + 1];
        Arrays.fill(K, Long.MAX_VALUE);
        K[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                long v = (long) (j - i) * (1 + Math.abs(A[i] - A[j]));
                K[j] = Math.min(K[j], Math.max(K[i], v));
            }

        }

        System.out.println(K[N]);
    }
}