import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

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

        int cheese = 0;

        int[][] map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) {
                    cheese++;
                }
                map[r][c] = v;
            }
        }

        int result = 0;
        while (0 < cheese) {
            boolean[][] outerAir = new boolean[N][M];
            boolean[][] visited = new boolean[N][M];
            Queue<int[]> q = new ArrayDeque<>();
            visited[0][0] = true;
            q.offer(new int[]{0, 0});
            while (!q.isEmpty()) {
                int[] cur = q.poll();

                outerAir[cur[0]][cur[1]] = true;

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];
                    if (outOfMap(nr, nc) || visited[nr][nc] || map[nr][nc] == 1) continue;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
            boolean[][] melt = new boolean[N][M];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == 0) continue;

                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (outOfMap(nr, nc) || map[nr][nc] == 1 || !outerAir[nr][nc]) continue;
                        count++;
                    }
                    if (2 <= count) {
                        melt[r][c] = true;
                    }
                }
            }
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (melt[r][c]) {
                        map[r][c] = 0;
                        cheese--;
                    }
                }
            }
            result++;
        }

        System.out.println(result);

    }
}