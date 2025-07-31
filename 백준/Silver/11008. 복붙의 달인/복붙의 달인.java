import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String p = st.nextToken();


            int i = 0;
            int result = 0;

            while (i < s.length()) {
                if (i + p.length() <= s.length() && s.startsWith(p, i)) {
                    result++;
                    i += p.length();
                } else {
                    result++;
                    i++;
                }
            }
            System.out.println(result);
        }
    }
}