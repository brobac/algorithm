import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = y - x;
            int count = 0;
            int d = 1;
            while (start < end) {
                count++;
                if (end <= start + d) {
                    break;
                }
                start += d;
                count++;
                if (end <= start + d) {
                    break;
                }
                end -= d;
                d++;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);

    }
}