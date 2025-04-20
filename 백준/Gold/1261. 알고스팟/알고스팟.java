import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || M <= r || N <= c;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        int[][] visited = new int[M][N];
        for (int r = 0; r < M; r++) {
            Arrays.fill(visited[r], 100000);
        }


        map = new char[M][N];
        for (int r = 0; r < M; r++) {
            map[r] = br.readLine().toCharArray();
        }

        Queue<int[]> q = new ArrayDeque<>();
        visited[0][0] = 0;
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int count = cur[2];


            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (outOfMap(nr, nc) || visited[nr][nc] <= count) continue;

                if (map[nr][nc] == '0') {
                    visited[nr][nc] = count;
                    q.offer(new int[]{nr, nc, count});
                } else if (map[nr][nc] == '1' && count + 1 < visited[nr][nc]) {
                    visited[nr][nc] = count + 1;
                    q.offer(new int[]{nr, nc, count + 1});
                }
            }
        }
        System.out.println(visited[M - 1][N - 1]);

    }
}