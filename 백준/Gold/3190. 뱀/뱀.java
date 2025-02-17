import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || N <= c;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        map[0][0] = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 2;
        }

        int L = Integer.parseInt(br.readLine());
        Queue<int[]> moveQ = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int C = st.nextToken().equals("L") ? -1 : 1;
            moveQ.offer(new int[]{X, C});
        }

        int[] move = moveQ.poll();

        int second = 0;
        int r = 0;
        int c = 0;
        int d = 0;
        while (true) {
            second++;
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (outOfMap(nr, nc) || map[nr][nc] == 1) break;


            if (map[nr][nc] == 0) {
                int[] tail = q.poll();
                map[tail[0]][tail[1]] = 0;
            }

            r = nr;
            c = nc;
            q.offer(new int[]{r, c});
            map[r][c] = 1;

            if (second == move[0]) {
                d += move[1];
                if (d == -1) {
                    d = 3;
                } else {
                    d %= 4;
                }

                if (!moveQ.isEmpty()) {
                    move = moveQ.poll();
                }
            }
        }
        System.out.println(second);
    }
}