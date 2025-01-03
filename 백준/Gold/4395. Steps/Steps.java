import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long X = Long.parseLong(st.nextToken());
            long Y = Long.parseLong(st.nextToken());

            if (X == Y) {
                sb.append("0\n");
                continue;
            }

            int result = 0;
            int d = 1;
            while (true) {
                X += d;
                result++;
                if (Y <= X) {
                    break;
                }

                Y -= d;
                result++;
                if (Y <= X) {
                    break;
                }
                d++;
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}