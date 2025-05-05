import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int min = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                int v = Integer.parseInt(br.readLine());
                min = Math.max(min, Math.min(v, L - v));
                max = Math.max(max, Math.max(v, L - v));

            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

}