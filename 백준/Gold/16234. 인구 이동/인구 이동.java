import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || N <= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        while (true) {
            boolean[][] visited = new boolean[N][N];
            boolean move = false;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (visited[r][c]) continue;
                    ArrayList<int[]> list = new ArrayList<>();
                    int sum = map[r][c];

                    Queue<int[]> q = new ArrayDeque<>();
                    visited[r][c] = true;
                    list.add(new int[]{r, c});
                    q.offer(new int[]{r, c});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int cr = cur[0];
                        int cc = cur[1];

                        for (int d = 0; d < 4; d++) {
                            int nr = cr + dr[d];
                            int nc = cc + dc[d];

                            if (outOfMap(nr, nc) || visited[nr][nc]) continue;

                            int gap = Math.abs(map[cr][cc] - map[nr][nc]);
                            if (gap < L || R < gap) continue;

                            visited[nr][nc] = true;
                            sum += map[nr][nc];
                            list.add(new int[]{nr, nc});
                            q.offer(new int[]{nr, nc});
                        }
                    }

                    if (2 <= list.size()) {
                        move = true;
                        int v = sum / list.size();
                        for (int[] pos : list) {
                            map[pos[0]][pos[1]] = v;
                        }
                    }
                }
            }
            if (!move) break;
            result++;
        }

        System.out.println(result);
    }
}