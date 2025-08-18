import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (; 0 < T; T--) {
            int N = Integer.parseInt(br.readLine());

            int odd = 0;
            int even = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                if (Integer.parseInt(st.nextToken()) % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }

            if (odd == even) {
                sb.append("heeda0528\n");
                continue;
            }

            sb.append(Math.max(odd, even) % 2 == 0 ? "heeda0528\n" : "amsminn\n");

        }

        System.out.println(sb);
    }
}