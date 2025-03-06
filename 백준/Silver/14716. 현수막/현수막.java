import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || M <= r || N <= c;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[M][N];

        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = st.nextToken().equals("1");
            }
        }

        int result = 0;

        boolean[][] visited = new boolean[M][N];

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (!map[r][c] || visited[r][c]) continue;

                Queue<int[]> q = new ArrayDeque<>();
                visited[r][c] = true;
                q.offer(new int[]{r, c});
                result++;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();

                    for (int d = 0; d < 8; d++) {
                        int nr = cur[0] + dr[d];
                        int nc = cur[1] + dc[d];

                        if (outOfMap(nr, nc) || !map[nr][nc] || visited[nr][nc]) continue;
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        System.out.println(result);
    }
}
