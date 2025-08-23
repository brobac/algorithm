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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            boolean[][] used = new boolean[Y][X];
            int count = 0;
            for (int r = 0; r < Y; r++) {
                for (int c = 0; c < X; c++) {
                    if (used[r][c]) continue;

                    count++;
                    used[r][c] = true;

                    int moveR = r + y;
                    int moveC = c + x;

                    if (Y <= moveR || X <= moveC) continue;

                    used[moveR][moveC] = true;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}