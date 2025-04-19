import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int R, C, sr, sc, tr, tc;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int row, int col) {
        return row < 0 || col < 0 || R <= row || C <= col;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        tr = Integer.parseInt(st.nextToken()) - 1;
        tc = Integer.parseInt(st.nextToken()) - 1;

        char[][] map = new char[R][C];
        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }
        int[][] visited = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                visited[r][c] = 1000;
            }
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        visited[sr][sc] = 0;
        while (true) {
            ArrayDeque<int[]> nq = new ArrayDeque<>();
            while (!q.isEmpty()) {
                int[] cur = q.pop();
                int cr = cur[0];
                int cc = cur[1];
                int time = visited[cr][cc];

                for (int d = 0; d < 4; d++) {
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];
                    if (outOfMap(nr, nc) || visited[nr][nc] <= time) continue;

                    if (map[nr][nc] == '#') {
                        System.out.println(time + 1);
                        return;
                    }
                    if (map[nr][nc] == '0' && time < visited[nr][nc]) {
                        visited[nr][nc] = time;
                        q.offer(new int[]{nr, nc});
                        continue;
                    }
                    if (map[nr][nc] == '1' && time + 1 < visited[nr][nc]) {
                        visited[nr][nc] = time + 1;
                        nq.offer(new int[]{nr, nc});
                    }

                }
            }
            q = nq;

        }
    }
}