import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("Case #").append(t).append(": ");
            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[2 * N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2 * N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] used = new boolean[2 * N];
            for (int i = 0; i < 2 * N; i++) {
                if (used[i]) continue;
                for (int j = i + 1; i < 2 * N; j++) {
                    if (used[j]) continue;
                    if (nums[i] / 3 * 4 == nums[j]) {
                        sb.append(nums[i]).append(" ");
                        used[j] = true;
                        break;
                    }
                }
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}