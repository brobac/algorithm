import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, P;
    static int[] S;
    static int[][] map;
    static int[] count;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || M <= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        S = new int[P + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        map = new int[N][M];
        count = new int[P + 1];

        for (int r = 0; r < N; r++) {
            char[] line = br.readLine().toCharArray();
            for (int c = 0; c < M; c++) {
                if (line[c] == '.') {
                    map[r][c] = 0;
                } else if (line[c] == '#') {
                    map[r][c] = -1;
                } else {
                    map[r][c] = line[c] - '0';
                    count[map[r][c]]++;
                }

            }
        }


        Queue<int[]>[] q = new ArrayDeque[P + 1];
        for (int i = 1; i <= P; i++) {
            q[i] = new ArrayDeque<>();
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == i) {
                        q[i].offer(new int[]{r, c, 0});
                    }
                }
            }
        }

        while (true) {
            boolean blocked = true;

            for (int i = 1; i <= P; i++) {
                boolean[][] visited = new boolean[N][M];
                ArrayList<int[]> newList = new ArrayList<>();


                while (!q[i].isEmpty()) {
                    int[] cur = q[i].poll();
                    int r = cur[0];
                    int c = cur[1];
                    int distance = cur[2];

                    if (distance == S[i]) {
                        int remainCount = q[i].size();
                        q[i].offer(new int[]{r, c, 0});
                        for (int j = 0; j < remainCount; j++) {
                            int[] temp = q[i].poll();
                            q[i].offer(new int[]{temp[0], temp[1], 0});
                        }
                        break;
                    }

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (outOfMap(nr, nc) || visited[nr][nc] || map[nr][nc] != 0) continue;
                        blocked = false;
                        count[i]++;
                        visited[nr][nc] = true;
                        q[i].offer(new int[]{nr, nc, distance + 1});
                        newList.add(new int[]{nr, nc});
                    }
                }

                for (int[] p : newList) {
                    map[p[0]][p[1]] = i;
                }

            }

            if (blocked) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= P; i++) {
            sb.append(count[i]).append(" ");
        }
        System.out.println(sb);


    }
}