import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int T = Integer.parseInt(br.readLine());

        int result = 0;

        for (int r = 0; r <= R - 3; r++) {
            for (int c = 0; c <= C - 3; c++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        list.add(map[r + i][c + j]);
                    }
                }
                Collections.sort(list);
                if (T <= list.get(4)) {
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}