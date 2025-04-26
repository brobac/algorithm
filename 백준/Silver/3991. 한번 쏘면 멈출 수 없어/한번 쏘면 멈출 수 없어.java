import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int[] ball = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            ball[i] = Integer.parseInt(st.nextToken());
        }

        int b = 1;
        int d = 1;
        int r = 0;
        int c = 0;
        int[][] map = new int[R][C];

        int total = R * C;
        for (int count = 0; count < total; count++) {
            map[r][c] = b;
            ball[b]--;
            if (ball[b] == 0) {
                b++;
            }
            c += d;
            if (c == C) {
                r++;
                c = C - 1;
                d *= -1;
            } else if (c == -1) {
                r++;
                c = 0;
                d *= -1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}