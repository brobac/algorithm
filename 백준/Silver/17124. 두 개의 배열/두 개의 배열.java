import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());

            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());

            }
            Arrays.sort(B);
            long result = 0;

            for (int i = 0; i < N; i++) {
                int l = 0;
                int r = M - 1;

                int gap = Integer.MAX_VALUE;
                int num = 0;

                while (l <= r) {
                    int mid = (l + r) / 2;
                    int curGap = Math.abs(A[i] - B[mid]);

                    if (curGap < gap) {
                        gap = curGap;
                        num = B[mid];
                    } else if (curGap == gap && B[mid] < num) {
                        num = B[mid];
                    }

                    if (gap == 0) break;

                    if (B[mid] < A[i]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                result += num;
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}