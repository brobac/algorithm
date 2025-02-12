import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);


        int result = 0;

        int gap1 = nums[1] - nums[0];
        int gap2 = nums[2] - nums[1];
        if (gap1 == gap2) {
            result = nums[2] + gap1;
        } else if (gap1 > gap2) {

            result = nums[0] + gap1 / 2;
        } else {
            result = nums[1] + gap2 / 2;
        }

        System.out.println(result);
    }
}