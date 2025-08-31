import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static int N, SIZE;

    static int[] sr = {0, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4};
    static int[] sc = {2, 2, 0, 1, 2, 3, 4, 1, 2, 3, 1, 3};

    static void fill(int i, int r, int c) {
        if (i == 0) {
            map[r][c] = '*';
            return;
        }
        for (int j = 0; j < sr.length; j++) {
            int nr = r + sr[j] * (int) Math.pow(5, i - 1);
            int nc = c + sc[j] * (int) Math.pow(5, i - 1);
            fill(i - 1, nr, nc);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        SIZE = (int) Math.pow(5, N);
        map = new char[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                map[r][c] = ' ';
            }
        }
        fill(N, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}