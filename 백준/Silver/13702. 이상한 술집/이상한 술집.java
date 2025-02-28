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

        long[] drink = new long[N];


        long min = 0;
        long max = 0;

        for (int i = 0; i < N; i++) {
            drink[i] = Long.parseLong(br.readLine());
            max = Math.max(max, drink[i]);
        }


        while (min <= max) {
            long mid = min + (max - min) / 2;

            if (mid == 0) break;

            long count = 0;
            for (long d : drink) {
                count += d / mid;
            }

            if (K <= count) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }


        System.out.println(max);

    }
}
