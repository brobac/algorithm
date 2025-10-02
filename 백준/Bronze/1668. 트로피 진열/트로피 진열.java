import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N];
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(br.readLine());
        }


        int max = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (max < h[i]) {
                count++;
                max = h[i];
            }
        }

        System.out.println(count);

        max = 0;
        count = 0;

        for (int i = N - 1; 0 <= i; i--) {
            if (max < h[i]) {
                count++;
                max = h[i];
            }
        }

        System.out.println(count);
    }
}