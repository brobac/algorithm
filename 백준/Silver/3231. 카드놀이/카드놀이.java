import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        for (int i = 0; i < N; i++) {
            nums[Integer.parseInt(br.readLine())] = i;
        }
        int result = 0;


        for (int i = 1; i < N; i++) {
            if (nums[i] > nums[i + 1]) result++;
        }


        System.out.println(result);
    }
}