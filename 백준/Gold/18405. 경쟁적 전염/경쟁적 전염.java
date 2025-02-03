import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || N <= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        Deque<int[]> q = new ArrayDeque<>();
        List<int[]>[] posList = new ArrayList[K + 1];
        for (int i = 1; i <= K; i++) {
            posList[i] = new ArrayList<>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 0) continue;

                posList[map[r][c]].add(new int[]{r, c});
            }
        }

        for (int i = 1; i <= K; i++) {
            for (int[] pos : posList[i]) {
                q.offer(new int[]{pos[0], pos[1], i, 0});
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int num = cur[2];
            int t = cur[3];
            if (t == S) break;


            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (outOfMap(nr, nc) || map[nr][nc] != 0) continue;
                map[nr][nc] = num;
                q.offer(new int[]{nr, nc, num, t + 1});
            }

        }


        System.out.println(map[X - 1][Y - 1]);
    }
}