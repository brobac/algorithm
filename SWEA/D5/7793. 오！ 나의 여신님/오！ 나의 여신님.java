import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, sr, sc, er, ec;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || M <= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            char[][] map = new char[N][M];
            int[][] visited = new int[N][M];
            Queue<int[]> q = new ArrayDeque<>();
            for (int r = 0; r < N; r++) {
                Arrays.fill(visited[r], Integer.MAX_VALUE);
            }
            for (int r = 0; r < N; r++) {
                map[r] = br.readLine().toCharArray();
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == 'S') {
                        sr = r;
                        sc = c;
                    } else if (map[r][c] == '*') {
                        visited[r][c] = 0;
                        q.offer(new int[]{r, c});
                    } else if (map[r][c] == 'D') {
                        er = r;
                        ec = c;
                    }
                }
            }

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (outOfMap(nr, nc) || map[nr][nc] == 'X' || visited[nr][nc] <= visited[r][c] + 1 || map[nr][nc] == 'D')
                        continue;

                    visited[nr][nc] = visited[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }

            visited[sr][sc] = 0;

            q.offer(new int[]{sr, sc});
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                if (map[r][c] == 'D') {
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (outOfMap(nr, nc) || map[nr][nc] == 'X' || visited[nr][nc] <= visited[r][c] + 1)
                        continue;

                    visited[nr][nc] = visited[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }

            sb.append("#").append(t).append(" ").append(visited[er][ec] == Integer.MAX_VALUE ? "GAME OVER" : visited[er][ec]).append("\n");
        }

        System.out.println(sb);
    }
}
