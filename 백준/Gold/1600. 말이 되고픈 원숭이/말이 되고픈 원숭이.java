import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, W, H;


    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[] hr = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] hc = {2, 1, -1, -2, -2, -1, 1, 2};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || H <= r || W <= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        boolean[][][] visited = new boolean[H][W][K + 1];

        for (int r = 0; r < H; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < W; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int k = cur[2];
            int time = cur[3];


            if (r == H - 1 && c == W - 1) {
                System.out.println(time);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (outOfMap(nr, nc) || map[nr][nc] == 1 || visited[nr][nc][k]) continue;

                visited[nr][nc][k] = true;

                q.offer(new int[]{nr, nc, k, time + 1});
            }

            if (k < K) {
                for (int h = 0; h < 8; h++) {
                    int nr = r + hr[h];
                    int nc = c + hc[h];

                    if (outOfMap(nr, nc) || map[nr][nc] == 1 || visited[nr][nc][k + 1]) continue;
                    visited[nr][nc][k + 1] = true;
                    q.offer(new int[]{nr, nc, k + 1, time + 1});
                }
            }

        }

        System.out.println(-1);
    }
}