import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || M <= c;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        boolean[][] visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            find:
            for (int c = 0; c < M; c++) {
                if (visited[r][c]) continue;
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{r, c});
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{r, c});
                visited[r][c] = true;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];
                    for (int d = 0; d < 8; d++) {
                        int nr = cr + dr[d];
                        int nc = cc + dc[d];
                        if (outOfMap(nr, nc)) continue;
                        if (!visited[nr][nc] && map[cr][cc] == map[nr][nc]) {
                            visited[nr][nc] = true;
                            list.add(new int[]{nr, nc});
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }

                for (int[] cur : list) {
                    int cr = cur[0];
                    int cc = cur[1];
                    for (int d = 0; d < 8; d++) {
                        int nr = cr + dr[d];
                        int nc = cc + dc[d];
                        if (outOfMap(nr, nc)) continue;
                        if (map[cr][cc] < map[nr][nc]) continue find;
                    }
                }

                result++;
            }
        }

        System.out.println(result);
    }
}