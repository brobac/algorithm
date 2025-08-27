import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int ROW = M + U + D;
        int COL = N + L + R;

        char[][] map = new char[ROW][COL];

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                map[r][c] = (r + c) % 2 == 0 ? '#' : '.';
            }
        }


        for (int r = 0; r < M; r++) {
            char[] line = br.readLine().toCharArray();
            for (int c = 0; c < N; c++) {
                map[U + r][L + c] = line[c];
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}