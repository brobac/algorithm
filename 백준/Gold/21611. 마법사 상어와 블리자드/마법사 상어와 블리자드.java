import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result;
    static int ballCount, lastBallIdx;
    static int[][] blizard;
    static int[][] map;
    static int[][] ballPos;

    static int[] magicR = {-1, 1, 0, 0};
    static int[] magicC = {0, 0, -1, 1};
    static int[] cellR = {0, 1, 0, -1};
    static int[] cellC = {-1, 0, 1, 0};


    static void printMap() {
        System.out.println("----------");
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("----------");

    }


    static int magic(int d, int s) {
        int shark = N / 2;

        int remove = 0;

        for (int i = 1; i <= s; i++) {
            int r = shark + magicR[d] * i;
            int c = shark + magicC[d] * i;
            if (map[r][c] != 0) {
                map[r][c] = 0;
                remove++;
            }
        }
        ballCount -= remove;

        return remove;

    }

    static void move(int remove) {
        // 움직일 필요가 없다.
        if (ballCount == 0) return;

        int[][] temp = new int[N][N];
        int check = 0;
        for (int i = 0; i <= lastBallIdx && check < ballCount; i++) {
            int r = ballPos[i][0];
            int c = ballPos[i][1];
            if (map[r][c] == 0) continue;

            int nr = ballPos[check][0];
            int nc = ballPos[check][1];
            temp[nr][nc] = map[r][c];
            check++;
        }

        map = temp;
    }

    static int bomb() {
        int remove = 0;
        // move로 정리를 하고 왔기 때문에 빈칸이 없음. 마지막 공 idx = ballCount-1

        int start = 0;
        int end = 0;

        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < ballCount; i++) {
            int r = ballPos[i][0];
            int c = ballPos[i][1];

            int ball = map[r][c];

            if (q.isEmpty() || map[q.peek()[0]][q.peek()[1]] == ball) {
                q.push(new int[]{r, c});
                continue;
            }

            if (map[q.peek()[0]][q.peek()[1]] != ball && 4 <= q.size()) {
                result += map[q.peek()[0]][q.peek()[1]] * q.size();
                remove += q.size();
                while (!q.isEmpty()) {
                    int[] p = q.pop();
                    int rr = p[0];
                    int rc = p[1];
                    map[rr][rc] = 0;
                }
                q.push(new int[]{r, c});
                continue;
            }
            q.clear();
            q.push(new int[]{r, c});
        }

        if (4 <= q.size()) {
            result += map[q.peek()[0]][q.peek()[1]] * q.size();
            remove += q.size();
            while (!q.isEmpty()) {
                int[] p = q.pop();
                int rr = p[0];
                int rc = p[1];
                map[rr][rc] = 0;
            }
        }

        ballCount -= remove;

        return remove;
    }

    static void transform() {
        int[][] temp = new int[N][N];
        int tempIdx = 0;


        int i = 0;

        while (i < ballCount) {
            int start = i;
            int end = i;
            while (end + 1 < ballCount && map[ballPos[start][0]][ballPos[start][1]] == map[ballPos[end + 1][0]][ballPos[end + 1][1]]) {
                end++;
            }
            int tr = ballPos[tempIdx][0];
            int tc = ballPos[tempIdx][1];
            temp[tr][tc] = end - start + 1;
            tempIdx++;

            if (tempIdx == N * N - 1) break;

            tr = ballPos[tempIdx][0];
            tc = ballPos[tempIdx][1];
            temp[tr][tc] = map[ballPos[start][0]][ballPos[start][1]];
            tempIdx++;

            if (tempIdx == N * N - 1) break;

            i = end + 1;
        }

        map = temp;
        ballCount = 0;
        for (int a = 0; a < N * N - 1; a++) {
            int r = ballPos[a][0];
            int c = ballPos[a][1];
            if (map[r][c] != 0) ballCount++;
        }


    }

    static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = 0;
        ballCount = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        lastBallIdx = N * N - 2;


        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] != 0) {
                    ballCount++;
                }
            }
        }

        blizard = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            blizard[i][0] = Integer.parseInt(st.nextToken()) - 1;
            blizard[i][1] = Integer.parseInt(st.nextToken());

        }
    }

    static void initBallPos() {
        ballPos = new int[N * N - 1][2];
        int d = 0;
        int r = N / 2;
        int c = N / 2;
        int size = 1;
        int count = 0;
        int idx = 0;
        for (int i = 1; i <= N * 2 - 2; i++) {
            for (int j = 1; j <= size; j++) {
                r += cellR[d];
                c += cellC[d];
                ballPos[idx][0] = r;
                ballPos[idx][1] = c;
                idx++;
            }
            d = (d + 1) % 4;
            count++;
            if (count == 2) {
                size++;
                count = 0;
            }
        }
        size--;
        for (int j = 1; j <= size; j++) {
            r += cellR[d];
            c += cellC[d];
            ballPos[idx][0] = r;
            ballPos[idx][1] = c;
            idx++;
        }


    }

    static void ballPosTest() {
        int[][] temp = new int[N][N];

        for (int i = 0; i <= lastBallIdx; i++) {
            int r = ballPos[i][0];
            int c = ballPos[i][1];

            temp[r][c] = i;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(temp[r][c] + "\t");
            }

            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {
        readInput();
        initBallPos();

        for (int[] v : blizard) {
            int remove = magic(v[0], v[1]);
            move(remove);
            while (true) {
                remove = bomb();
                if (remove == 0) break;
                move(remove);
            }
            transform();
        }

        System.out.println(result);

    }
}