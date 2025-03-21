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
        int[] time = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        long min = 1;
        long max = 1000000000000L;

        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;
            for (int t : time) {
                count += mid / t;
                if (M <= count) break;
            }

            if (M <= count) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }

        }

        System.out.println(max + 1);
    }
}