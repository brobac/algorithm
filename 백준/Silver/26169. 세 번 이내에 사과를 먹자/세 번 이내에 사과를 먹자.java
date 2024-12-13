import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int N = 5;
    static int[][] map;
    static boolean[][] visited;
    static int result = 0;


    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || 5 <= r || 5 <= c;
    }

    static void solution(int r, int c, int cnt, int apple) {
        if (cnt == 3) {
            if (2 <= apple) {
                result = 1;
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (outOfMap(nr, nc) || visited[nr][nc] || map[nr][nc] == -1) continue;

            visited[nr][nc] = true;
            solution(nr, nc, cnt + 1, map[nr][nc] == 1 ? apple + 1 : apple);
            visited[nr][nc] = false;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        visited[R][C] = true;
        solution(R, C, 0, 0);
        System.out.println(result);
    }
}