import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] size = new long[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            size[i][0] = Integer.parseInt(st.nextToken());
            size[i][1] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(size, (a, b) -> {
            if (a[0] == b[0]) {
                return (int) (b[1] - a[1]);
            }
            return (int) (b[0] - a[0]);
        });

        long X = size[0][0];
        long Y = size[0][1];
        long result = X * Y;
        for (int i = 1; i < N; i++) {
            if (Y < size[i][1]) {
                result += size[i][0] * (size[i][1] - Y);
                Y = size[i][1];
            }

        }

        System.out.println(result);
    }
}