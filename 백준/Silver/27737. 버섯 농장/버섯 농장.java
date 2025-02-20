import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static long M, K;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || N <= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        int[][] map = new int[N][N];

        int blockedCount = 0;

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                blockedCount += map[r][c];
            }
        }

        if (blockedCount == N * N) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        List<Integer> list = new ArrayList<>();

        boolean[][] visited = new boolean[N][N];


        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (visited[r][c] || map[r][c] == 1) continue;

                visited[r][c] = true;
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{r, c});

                int size = 1;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nr = cr + dr[d];
                        int nc = cc + dc[d];

                        if (outOfMap(nr, nc) || visited[nr][nc] || map[nr][nc] == 1) continue;
                        visited[nr][nc] = true;
                        size++;
                        q.offer(new int[]{nr, nc});
                    }
                }
                list.add(size);
            }
        }

        for (int v : list) {
            int require = (int) Math.ceil((double) v / K);
            if (M < require) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            M -= require;
        }

        System.out.println("POSSIBLE");
        System.out.println(M);

    }
}