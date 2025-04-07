import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, oil;
    static int[][] map;

    static Man[] m;

    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};


    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || N <= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        oil = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = st.nextToken().equals("1") ? -1 : 0;
            }
        }
        st = new StringTokenizer(br.readLine());
        int carRow = Integer.parseInt(st.nextToken()) - 1;
        int carCol = Integer.parseInt(st.nextToken()) - 1;

        m = new Man[M + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken()) - 1;
            int sc = Integer.parseInt(st.nextToken()) - 1;
            int er = Integer.parseInt(st.nextToken()) - 1;
            int ec = Integer.parseInt(st.nextToken()) - 1;
            m[i] = new Man(sr, sc, er, ec);
            map[sr][sc] = i;
        }

        work:
        for (int i = 0; i < M; i++) {
            boolean[][] visited = new boolean[N][N];
            visited[carRow][carCol] = true;
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{carRow, carCol, oil, 0});

            int target = -1;
            int minTime = Integer.MAX_VALUE;

            // 손님 태우기
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int o = cur[2];
                int t = cur[3];

                if (o == 0) {
                    continue;
                }

                if (minTime < t) break;


                if (0 < map[r][c]) {
                    if (t < minTime) {
                        minTime = t;
                        target = map[r][c];
                        continue;
                    }

                    if (r < m[target].startRow || (r == m[target].startRow && c < m[target].startCol)) {
                        target = map[r][c];
                        continue;
                    }
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (outOfMap(nr, nc) || visited[nr][nc] || map[nr][nc] == -1) continue;

                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, o - 1, t + 1});
                }

            }

            if (target == -1 || oil == 0) {
                System.out.println(-1);
                return;
            }

            carRow = m[target].startRow;
            carCol = m[target].startCol;
            oil -= minTime;
            map[carRow][carCol] = 0;



            visited = new boolean[N][N];
            visited[carRow][carCol] = true;
            q.clear();
            q.offer(new int[]{carRow, carCol, oil, 0});

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int o = cur[2];
                int spend = cur[3];

                if (r == m[target].endRow && c == m[target].endCol) {
                    carRow = r;
                    carCol = c;
                    oil = o + spend * 2;

                    continue work;
                }

                if (o == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (outOfMap(nr, nc) || visited[nr][nc] || map[nr][nc] == -1) continue;

                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, o - 1, spend + 1});
                }

            }


            System.out.println(-1);
            return;

        }
        System.out.println(oil);

    }

    static class Man {
        int startRow, startCol, endRow, endCol;

        public Man(int startRow, int startCol, int endRow, int endCol) {
            this.startRow = startRow;
            this.startCol = startCol;
            this.endRow = endRow;
            this.endCol = endCol;
        }

        @Override
        public String toString() {
            return "Man{" +
                    "startRow=" + startRow +
                    ", startCol=" + startCol +
                    ", endRow=" + endRow +
                    ", endCol=" + endCol +
                    '}';
        }
    }
}