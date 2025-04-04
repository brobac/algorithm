import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long Z = Y * 100 / X;


        if (Z == 100) {
            System.out.println(-1);
            return;
        }

        long l = 1;
        long r = 1000000000;
        while (l <= r) {
            long mid = (l + r) / 2;

            if (Z < (Y + mid) * 100 / (X + mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (Z == (Y + 1000000000) * 100 / (X + 1000000000)) {
            System.out.println(-1);
            return;
        }
        System.out.println(r + 1);

    }
}