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

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;
        int sum = 0;
        int result = 0;
        while (r < N) {
            if (M < A[r]) {
                l = r + 1;
                r = r + 1;
                sum = 0;
                continue;
            }

            while (M < sum + A[r]) {
                sum -= A[l++];
            }
            sum += A[r];
            if (result < sum) {
                result = sum;
            }
            r++;
        }


        System.out.println(result);
    }
}