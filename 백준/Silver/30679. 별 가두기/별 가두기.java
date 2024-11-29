import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || M <= c;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Integer> holdList = new ArrayList<>();
        find:
        for (int i = 0; i < N; i++) {
            boolean[][][] visited = new boolean[N][M][4];
            int r = i;
            int c = 0;
            int d = 0;

            int nr = r + dr[d] * map[r][c];
            int nc = c + dc[d] * map[r][c];

            while (!outOfMap(nr, nc)) {
                if (visited[nr][nc][d]) {
                    holdList.add(i + 1);
                    continue find;
                }
                visited[nr][nc][d] = true;
                d = (d + 1) % 4;
                int size = map[nr][nc];
                nr += dr[d] * size;
                nc += dc[d] * size;

            }

        }
        sb.append(holdList.size()).append("\n");
        for (int v : holdList) {
            sb.append(v).append(" ");
        }
        System.out.println(sb);
    }
}