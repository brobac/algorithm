import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[] pa = new long[S];


        long min = 1;
        long max = 1;

        for (int i = 0; i < S; i++) {
            pa[i] = Long.parseLong(br.readLine());
            max = Math.max(max, pa[i]);
        }


        while (min <= max) {
            long mid = min + (max - min) / 2;

            long count = 0;
            for (long d : pa) {
                count += d / mid;
            }

            if (C <= count) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        long use = min - 1;

        long sum = 0;
        for (long p : pa) {
            sum += p;
        }
        System.out.println(sum - use * C);
    }
}