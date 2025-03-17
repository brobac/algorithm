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

        long a = 0, b = 0;

        long result = 0;

        int i = N - 1;
        while (0 < i) {
            while (0 < i) {
                if (nums[i] == nums[i - 1]) {
                    a = nums[i];
                    i -= 2;
                    break;
                }

                if (nums[i] - 1 == nums[i - 1]) {
                    a = nums[i] - 1;
                    i -= 2;
                    break;
                }
                i--;
            }
            while (0 < i) {
                if (nums[i] == nums[i - 1]) {
                    b = nums[i];
                    i -= 2;
                    break;
                }

                if (nums[i] - 1 == nums[i - 1]) {
                    b = nums[i] - 1;
                    i -= 2;
                    break;
                }
                i--;
            }
            if (a != 0 && b != 0) {
                result += a * b;
                a = 0;
                b = 0;
            }
        }

        System.out.println(result);

    }
}