import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] pos = new int[2][2];
        int point = 0;
        find:
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                if (st.nextToken().equals("1")) {
                    pos[point][0] = r;
                    pos[point][1] = c;
                    point++;
                    if (point == 2) break find;
                }
            }
        }

        System.out.println(Math.abs(pos[0][0] - pos[1][0]) + Math.abs(pos[0][1] - pos[1][1]));
    }
}