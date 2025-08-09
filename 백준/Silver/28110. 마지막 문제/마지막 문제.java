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
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int gap = 0;
        int result = -1;

        for (int i = 0; i < N - 1; i++) {
            int mid = (num[i] + num[i + 1]) / 2;
            if (mid == num[i]) continue;

            if (mid - num[i] > gap) {
                gap = mid - num[i];
                result = mid;
            }
        }

        System.out.println(result);
    }
}