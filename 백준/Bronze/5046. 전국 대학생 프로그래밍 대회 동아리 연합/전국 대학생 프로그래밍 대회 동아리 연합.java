import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int result = Integer.MAX_VALUE;

        for (; 0 < H; H--) {
            int p = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < W; i++) {
                int a = Integer.parseInt(st.nextToken());
                int cost = N * p;
                if (N <= a && cost <= B && cost < result) {
                    result = cost;
                    break;
                }
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? "stay home" : result);

    }
}