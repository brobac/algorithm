import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, emptyCount, result;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static ArrayList<int[]> virusList;
    static int[] selected;
    static int[][] map;

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || N <= c;
    }

    static void solution(int cnt, int start) {
        if (cnt == M) {
            int remain = emptyCount;
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < M; i++) {
                int[] pos = virusList.get(selected[i]);
                int r = pos[0];
                int c = pos[1];
                visited[r][c] = true;
                q.offer(new int[]{r, c, 0});
            }
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int t = cur[2];

                if (result <= t) {
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (outOfMap(nr, nc) || visited[nr][nc] || map[nr][nc] == 1) continue;

                    if (map[nr][nc] == 0) {
                        remain--;
                    }

                    if (remain == 0) {
                        result = Math.min(result, t + 1);
                    }
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, t + 1});

                }
            }
            return;
        }

        for (int i = start; i < virusList.size(); i++) {
            selected[cnt] = i;
            solution(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        emptyCount = 0;
        result = Integer.MAX_VALUE;
        virusList = new ArrayList<>();
        selected = new int[M];

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int v = Integer.parseInt(st.nextToken());

                map[r][c] = v;
                if (v == 0) {
                    emptyCount++;
                } else if (v == 2) {
                    virusList.add(new int[]{r, c});
                }
            }
        }
        if (emptyCount == 0) {
            System.out.println(0);
            return;
        }

        solution(0, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);


    }
}