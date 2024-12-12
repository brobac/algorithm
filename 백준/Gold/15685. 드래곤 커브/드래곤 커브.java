import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[101][101];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            map[r][c] = true;

            ArrayList<Integer> list = new ArrayList<>();
            list.add(d);
            for (int gen = 0; gen < g; gen++) {
                for (int j = list.size() - 1; 0 <= j; j--) {
                    list.add((list.get(j) + 1) % 4);
                }
            }
            for (int v : list) {
                int nr = r + dr[v];
                int nc = c + dc[v];
                map[nr][nc] = true;
                r = nr;
                c = nc;
            }
        }

        int result = 0;

        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                if (map[r][c] && map[r + 1][c] && map[r][c + 1] && map[r + 1][c + 1]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}