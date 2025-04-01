import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, T;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || M <= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][][] visited = new boolean[2][N][M];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int t = cur[2];
            int sword = cur[3];

            if (r == N - 1 && c == M - 1) {
                System.out.println(t);
                return;
            }

            if (t == T) break;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (outOfMap(nr, nc) || visited[sword][nr][nc]) continue;

                if (map[nr][nc] == 2) {
                    visited[0][nr][nc] = true;
                    q.offer(new int[]{nr, nc, t + 1, 1});
                    continue;
                }
                if (map[nr][nc] == 1 && sword == 1) {
                    visited[1][nr][nc] = true;
                    q.offer(new int[]{nr, nc, t + 1, 1});
                    continue;
                }
                if (map[nr][nc] == 0) {
                    visited[sword][nr][nc] = true;
                    q.offer(new int[]{nr, nc, t + 1, sword});
                }

            }

        }

        System.out.println("Fail");
    }
}