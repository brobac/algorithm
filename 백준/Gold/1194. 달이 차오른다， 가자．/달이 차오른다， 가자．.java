import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static char[][] map;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || M <= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];


        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][64];

        for (int r = 0; r < N; r++) {
            char[] row = br.readLine().toCharArray();
            for (int c = 0; c < M; c++) {
                map[r][c] = row[c];
                if (map[r][c] == '0') {
                    q.offer(new int[]{r, c, 0, 0});
                    visited[r][c][0] = true;
                }
            }
        }


        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int keys = cur[2];
            int time = cur[3];

            if (map[r][c] == '1') {
                System.out.println(time);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (outOfMap(nr, nc) || map[nr][nc] == '#' || visited[nr][nc][keys]) continue;

                if (map[nr][nc] == '.' || map[nr][nc] == '0' || map[nr][nc] == '1') {
                    visited[nr][nc][keys] = true;
                    q.offer(new int[]{nr, nc, keys, time + 1});
                    continue;
                }

                if ('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
                    int nextKeys = keys | (1 << (map[nr][nc] - 'a'));
                    visited[nr][nc][nextKeys] = true;
                    q.offer(new int[]{nr, nc, nextKeys, time + 1});
                    continue;
                }

                if ('A' <= map[nr][nc] && map[nr][nc] <= 'F' && (keys & (1 << (map[nr][nc] - 'A'))) != 0) {
                    visited[nr][nc][keys] = true;
                    q.offer(new int[]{nr, nc, keys, time + 1});
                }
            }
        }

        System.out.println(-1);

    }
}