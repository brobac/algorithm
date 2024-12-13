import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;


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
        K = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int r = 0; r < N; r++) {
            map[r] = br.readLine().toCharArray();
        }
        boolean[][][] visited = new boolean[N][M][K + 1];

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[3] == b[3]) {
                if (a[0] == b[0]) return b[1] - a[1];
                return b[0] - a[0];
            }
            return a[3] - b[3];
        });
        visited[0][0][0] = true;
        q.offer(new int[]{0, 0, 0, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int k = cur[2];
            int t = cur[3];

//            System.out.println("r ; " + r + " c : " + c + " k : " + k + " t : " + t);
            if (r == N - 1 && c == M - 1) {
                System.out.println(t);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (outOfMap(nr, nc) || visited[nr][nc][k] || map[nr][nc] == '1') continue;
                visited[nr][nc][k] = true;
                q.offer(new int[]{nr, nc, k, t + 1});
            }

            if (k < K) {
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (outOfMap(nr, nc) || visited[nr][nc][k + 1] || map[nr][nc] == '0') continue;
                    visited[nr][nc][k + 1] = true;
                    boolean day = t % 2 == 1;
                    if (day) {
                        q.offer(new int[]{nr, nc, k + 1, t + 1});
                    } else {
                        q.offer(new int[]{nr, nc, k + 1, t + 2});
                    }
                }
            }
        }
        System.out.println(-1);
    }
}