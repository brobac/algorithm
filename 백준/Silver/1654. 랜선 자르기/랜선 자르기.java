import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] nums = new long[K];
        long lo = 1;
        long hi = 0;
        for (int i = 0; i < K; i++) {
            nums[i] = Long.parseLong(br.readLine());
            hi = Math.max(hi, nums[i]);
        }
        Arrays.sort(nums);

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long count = 0;
            for (int i = K - 1; 0 <= i; i--) {
                long v = nums[i];
                count += v / mid;
                if (N <= count || v < mid) break;
            }
            if (N <= count) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(lo - 1);
    }
}