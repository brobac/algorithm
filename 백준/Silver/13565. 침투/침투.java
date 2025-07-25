import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int R, C;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || R <= r || C <= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[R][C];

        Queue<int[]> q = new ArrayDeque<>();
        for (int c = 0; c < C; c++) {
            if (map[0][c] == '0') {
                q.offer(new int[]{0, c});
                visited[0][c] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            if (cr == R - 1) {
                System.out.println("YES");
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if (outOfMap(nr, nc) || map[nr][nc] == '1' || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }

        System.out.println("NO");

    }
}