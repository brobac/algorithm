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

        char[][] map = new char[2 * R][2 * C];

        for (int r = 0; r < R; r++) {
            char[] input = br.readLine().toCharArray();
            for (int c = 0; c < C; c++) {
                map[r][c] = input[c];
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                map[r][2 * C - 1 - c] = map[r][c];
            }
        }


        for (int r = 0; r < R; r++) {
            for (int c = 0; c < 2 * C; c++) {
                map[2 * R - 1 - r][c] = map[r][c];
            }
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()) - 1;
        int B = Integer.parseInt(st.nextToken()) - 1;

        if (map[A][B] == '#') {
            map[A][B] = '.';
        } else {
            map[A][B] = '#';
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 2 * R; r++) {
            for (int c = 0; c < 2 * C; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}