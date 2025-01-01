import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        for (int r = 0; r < H; r++) {
            int time = -1;
            for (char c : br.readLine().toCharArray()) {
                if (c == 'c') {
                    sb.append("0 ");
                    time = 1;
                    continue;
                }

                if (time == -1) {
                    sb.append("-1 ");
                    continue;
                }

                sb.append(time++).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}