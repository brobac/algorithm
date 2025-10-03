import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int l = N - 1;
        int r = 0;
        int t = N - 1;
        int b = 0;

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (row[j] != 'G') continue;
                l = Math.min(l, j);
                r = Math.max(r, j);
                t = Math.min(t, i);
                b = Math.max(b, i);
            }
        }

        int x = l == r ? 0 : Math.min((N - 1) - l, r);
        int y = t == b ? 0 : Math.min((N - 1) - t, b);

        System.out.println(x + y);

    }
}