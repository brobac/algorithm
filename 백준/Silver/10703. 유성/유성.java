import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int R = Integer.parseInt(st.nextToken());
        final int S = Integer.parseInt(st.nextToken());

        char[][] input = new char[R][S];
        char[][] output = new char[R][S];

        for (int r = 0; r < R; r++) {
            input[r] = br.readLine().toCharArray();
            Arrays.fill(output[r], '.');
        }

        int down = Integer.MAX_VALUE;

        for (int c = 0; c < S; c++) {
            int ground = 0;
            while (ground + 1 < R && input[ground + 1][c] != '#') {
                ground++;
            }
            int top = ground;
            while (0 < top && input[top - 1][c] == '.') {
                top--;
            }

            if (top == 0) continue;

            down = Math.min(down, ground - top + 1);

        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < S; c++) {
                if (input[r][c] == 'X') {
                    output[r + down][c] = 'X';
                } else if (input[r][c] == '#') {
                    output[r][c] = '#';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < S; c++) {
                sb.append(output[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}