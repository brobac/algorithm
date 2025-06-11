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
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        for (int i = 0; i < M; i++) {
            sum += num[i];
        }
        long result = sum;
        for (int i = M; i < N; i++) {
            sum = sum + num[i] - num[i - M];
            result = Math.max(result, sum);
        }

        System.out.println(result);

    }
}