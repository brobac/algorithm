import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0
                || N <= r || M <= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for (int c = 0; c < M; c++) {
            map[N][c] = Integer.MAX_VALUE;
        }

        int lo = 1;
        int hi = 1000000000;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            int count = 0;
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][M];

            for (int c = 0; c < M; c++) {
                if (map[0][c] <= mid) {
                    count++;
                    q.offer(new int[]{0, c});
                    visited[0][c] = true;
                }

                if (K <= count) break;
            }

            if (count < K) {
                for (int r = 1; r < N; r++) {
                    if (map[r][0] <= mid) {
                        count++;
                        q.offer(new int[]{r, 0});
                        visited[r][0] = true;
                    }
                    if (map[r][M - 1] <= mid) {
                        count++;
                        q.offer(new int[]{r, M - 1});
                        visited[r][M - 1] = true;
                    }

                    if (K <= count) break;
                }
            }

            if (count < K) {
                while (!q.isEmpty()) {

                    int[] cur = q.poll();
                    int r = cur[0];
                    int c = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (outOfMap(nr, nc) || visited[nr][nc] || mid < map[nr][nc]) continue;
                        visited[nr][nc] = true;
                        count++;
                        q.offer(new int[]{nr, nc});

                        if (K <= count) break;
                    }
                }
            }


            if (K <= count) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(hi + 1);
    }
}