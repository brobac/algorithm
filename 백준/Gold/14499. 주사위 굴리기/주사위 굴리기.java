import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, r, c, K;
    static int[][] map;
    static int[] dice = new int[6];


    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || M <= c;
    }

    static int north() {

        int nr = r - 1;
        int nc = c;

        if (outOfMap(nr, nc)) return -1;

        int[] temp = new int[6];
        temp[0] = dice[1];
        temp[1] = dice[2];
        temp[2] = dice[3];
        temp[3] = dice[0];
        temp[4] = dice[4];
        temp[5] = dice[5];

        if (map[nr][nc] == 0) {
            map[nr][nc] = temp[3];
        } else {
            temp[3] = map[nr][nc];
            map[nr][nc] = 0;
        }
        dice = temp;
        r = nr;
        c = nc;
        return temp[1];
    }

    static int south() {
        int nr = r + 1;
        int nc = c;

        if (outOfMap(nr, nc)) return -1;

        int[] temp = new int[6];
        temp[0] = dice[3];
        temp[1] = dice[0];
        temp[2] = dice[1];
        temp[3] = dice[2];
        temp[4] = dice[4];
        temp[5] = dice[5];

        if (map[nr][nc] == 0) {
            map[nr][nc] = temp[3];
        } else {
            temp[3] = map[nr][nc];
            map[nr][nc] = 0;
        }
        dice = temp;
        r = nr;
        c = nc;
        return temp[1];
    }

    static int east() {
        int nr = r;
        int nc = c + 1;

        if (outOfMap(nr, nc)) return -1;

        int[] temp = new int[6];
        temp[0] = dice[0];
        temp[1] = dice[4];
        temp[2] = dice[2];
        temp[3] = dice[5];
        temp[4] = dice[3];
        temp[5] = dice[1];

        if (map[nr][nc] == 0) {
            map[nr][nc] = temp[3];
        } else {
            temp[3] = map[nr][nc];
            map[nr][nc] = 0;
        }

        dice = temp;
        r = nr;
        c = nc;
        return temp[1];
    }

    static int west() {
        int nr = r;
        int nc = c - 1;

        if (outOfMap(nr, nc)) return -1;

        int[] temp = new int[6];
        temp[0] = dice[0];
        temp[1] = dice[5];
        temp[2] = dice[2];
        temp[3] = dice[4];
        temp[4] = dice[1];
        temp[5] = dice[3];

        if (map[nr][nc] == 0) {
            map[nr][nc] = temp[3];
        } else {
            temp[3] = map[nr][nc];
            map[nr][nc] = 0;
        }
        dice = temp;
        r = nr;
        c = nc;
        return temp[1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int m = Integer.parseInt(st.nextToken());

            int v = -1;
            switch (m) {
                case 1:
                    v = east();
                    break;
                case 2:
                    v = west();
                    break;
                case 3:
                    v = north();
                    break;
                case 4:
                    v = south();
            }

            if (v == -1) continue;
            bw.write(v + "\n");
        }

        bw.flush();
    }
}