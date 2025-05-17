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

            int zero = 0;
            int one = 0;

            char[] A = st.nextToken().toCharArray();
            char[] B = st.nextToken().toCharArray();

            int N = A.length;
            for (int i = 0; i < N; i++) {
                if (A[i] == B[i]) continue;

                if (A[i] == '0') zero++;
                else one++;
            }

            sb.append(Math.max(zero, one)).append("\n");
        }

        System.out.println(sb);
    }
}