import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K, result, maxScore;
    static int[][] map;
    static boolean[][] visited;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || R + 3 <= r || C <= c;
    }

    static void dfs(int r, int c, int n) {
        maxScore = Math.max(maxScore, r - 2);
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (outOfMap(nr, nc) || visited[nr][nc]) continue;


            if (n < 0 && map[nr][nc] != 0) {
                dfs(nr, nc, map[nr][nc]);
            } else if (0 < n && map[nr][nc] == n || 0 < n && map[nr][nc] == -1 * n) {
                dfs(nr, nc, map[nr][nc]);
            }

        }

    }


    static void clearMap() {
        map = new int[R + 3][C];
    }

    static boolean downCheck(int r, int c) {
        if (R + 3 <= r + 2) return false;
        return map[r + 2][c] == 0 && map[r + 1][c - 1] == 0 && map[r + 1][c + 1] == 0;
    }

    static boolean leftCheck(int r, int c) {
        if (R + 3 <= r + 2 || c - 2 < 0) return false;
        return map[r - 1][c - 1] == 0 && map[r][c - 2] == 0 && map[r + 1][c - 1] == 0 && map[r + 1][c - 2] == 0 && map[r + 2][c - 1] == 0;

    }

    static boolean rightCheck(int r, int c) {
        if (R + 3 <= r + 2 || C <= c + 2) return false;
        return map[r - 1][c + 1] == 0 && map[r][c + 2] == 0 && map[r + 1][c + 1] == 0 && map[r + 1][c + 2] == 0 && map[r + 2][c + 1] == 0;
    }

    static void printMap() {
        System.out.println("-----print map-----");
        for (int r = 0; r < R + 3; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(map[r][c] + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = 0;

        map = new int[R + 3][C];

        for (int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());

            int r = 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());


            while (true) {
                while (downCheck(r, c)) {
                    r++;
                }

                if (leftCheck(r, c)) {
                    r++;
                    c--;
                    d = (d + 3) % 4;
                } else if (rightCheck(r, c)) {
                    r++;
                    c++;
                    d = (d + 1) % 4;
                }

                if (!downCheck(r, c) && !leftCheck(r, c) && !rightCheck(r, c)) break;
            }


            // 골램이 숲을 벗어난 경우
            if (r <= 3) {
                clearMap();
                continue;
            }


            // 골램 자리차지
            map[r][c] = k;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                map[nr][nc] = i == d ? -1 * k : k;
            }

            visited = new boolean[R + 3][C];
            maxScore = 0;
            dfs(r, c, k);
            result += maxScore;

        }

        System.out.println(result);
    }
}
