import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        long sum = Long.MAX_VALUE;
        int[] result = new int[3];
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;
            while (left < right) {
                long temp = (long)nums[i] + nums[left] + nums[right];
                if (Math.abs(temp) < sum) {
                    sum = Math.abs(temp);
                    result[0] = nums[i];
                    result[1] = nums[left];
                    result[2] = nums[right];
                }
                if (temp < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v : result) {
            sb.append(v).append(" ");
        }
        System.out.println(sb);
    }
}