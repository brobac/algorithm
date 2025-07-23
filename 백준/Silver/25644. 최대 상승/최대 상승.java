import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        int low = a[0];
        int high = a[0];

        for (int i = 1; i < N; i++) {
            if (high < a[i]) {
                high = a[i];
                result = Math.max(result, high - low);
            } else if (a[i] < low) {
                high = a[i];
                low = a[i];
            }
        }

        System.out.println(result);
    }
}