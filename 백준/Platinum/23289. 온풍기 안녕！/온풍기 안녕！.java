import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, K;
    static int[][] room; // [행][열]
    static List<int[]> checkList = new ArrayList<>();
    static List<int[]> heaterList = new ArrayList<>();
    static boolean[][][] blocked; // [방향][행][열]

    // 오른쪽, 왼쪽, 위쪽, 아래쪽
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] hr = {{-1, 0, 1}, {-1, 0, 1}, {-1, -1, -1}, {1, 1, 1}};
    static int[][] hc = {{1, 1, 1}, {-1, -1, -1}, {-1, 0, 1}, {-1, 0, 1}};

    static int[][][][] blockCheck = {
            {
                    {
                            {-1, 0, 3}, {-1, 0, 0}
                    },
                    {
                            {0, 0, 0}
                    },
                    {
                            {1, 0, 2}, {1, 0, 0}
                    },
            },
            {
                    {
                            {-1, 0, 3}, {-1, 0, 1}
                    },
                    {
                            {0, 0, 1}
                    },
                    {
                            {1, 0, 2}, {1, 0, 1}
                    },
            },
            {
                    {
                            {0, -1, 0}, {0, -1, 2}
                    },
                    {
                            {0, 0, 2}
                    },
                    {
                            {0, 1, 1}, {0, 1, 2}
                    },
            },
            {
                    {
                            {0, -1, 0}, {0, -1, 3}
                    },
                    {
                            {0, 0, 3}
                    },
                    {
                            {0, 1, 1}, {0, 1, 3}
                    },
            },

    };

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || R <= r || C <= c;
    }


    static void heat() {
        for (int[] heater : heaterList) {
            int heaterR = heater[0];
            int heaterC = heater[1];
            int heaterD = heater[2];

            boolean[][] visited = new boolean[R][C];

            Queue<int[]> q = new ArrayDeque<>();
            int firstR = heaterR + dr[heaterD];
            int firstC = heaterC + dc[heaterD];
            visited[firstR][firstC] = true;
            q.offer(new int[]{firstR, firstC, heaterD, 5});

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int d = cur[2];
                int temperature = cur[3];

                room[r][c] += temperature;

                if (temperature == 1) continue;

                blow:
                for (int b = 0; b < 3; b++) {
                    int nr = r + hr[d][b];
                    int nc = c + hc[d][b];

                    if (outOfMap(nr, nc) || visited[nr][nc]) continue;

                    for (int[] block : blockCheck[d][b]) {
                        int br = r + block[0];
                        int bc = c + block[1];
                        int bd = block[2];
                        if (blocked[bd][br][bc]) continue blow;
                    }

                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, d, temperature - 1});
                }

            }

        }
    }

    static void adjust() {

        int[][] change = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (outOfMap(nr, nc) || blocked[d][r][c] || room[r][c] <= room[nr][nc]) continue;

                    int gap = Math.abs(room[r][c] - room[nr][nc]) / 4;
                    if (gap == 0) continue;
                    if (room[r][c] > room[nr][nc]) {
                        change[r][c] -= gap;
                        change[nr][nc] += gap;
                    } else {
                        change[r][c] += gap;
                        change[nr][nc] -= gap;
                    }
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                room[r][c] += change[r][c];
            }
        }

    }

    static void down() {
        for (int c = 0; c < C; c++) {
            if (0 < room[0][c]) {
                room[0][c]--;
            }
            if (0 < room[R - 1][c]) {
                room[R - 1][c]--;
            }
        }
        for (int r = 1; r < R - 1; r++) {
            if (0 < room[r][0]) {
                room[r][0]--;
            }
            if (0 < room[r][C - 1]) {
                room[r][C - 1]--;
            }
        }

    }

    static boolean checkTemperature() {
        for (int[] pos : checkList) {
            if (room[pos[0]][pos[1]] < K) return false;
        }

        return true;
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        room = new int[R][C];
        blocked = new boolean[4][R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                int v = Integer.parseInt(st.nextToken());
                if (1 <= v && v <= 4) {
                    heaterList.add(new int[]{r, c, v - 1});
                } else if (v == 5) {
                    checkList.add(new int[]{r, c});
                }
            }
        }

        int W = Integer.parseInt(br.readLine());
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());

            if (t == 0) {
                blocked[2][r][c] = true;
                blocked[3][r - 1][c] = true;
            } else {
                blocked[0][r][c] = true;
                blocked[1][r][c + 1] = true;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        init();
        int count = 0;
        while (count < 100) {
            heat();
            adjust();
            down();
            count++;
            if (checkTemperature()) {
                System.out.println(count);
                return;
            }
        }
        System.out.println(101);
    }
}