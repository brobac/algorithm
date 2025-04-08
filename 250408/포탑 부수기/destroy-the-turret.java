import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int ar, ac, tr, tc;

    static int[][] map, time;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] used;


    static boolean onlyOne() {
        int count = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (0 < map[r][c]) count++;
                if (2 <= count) return false;
            }
        }
        return true;
    }

    static int maxPower() {
        int result = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                result = Math.max(result, map[r][c]);
            }
        }

        return result;
    }

    static void findTarget() {
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                // 공격자 제외
                if (r == ar && c == ac) continue;
                // 부서진 포탑이거나 공격력이 더 낮은 걍우
                if (map[r][c] <= 0 || map[r][c] < max) continue;

                // 1. 공격력이 더 높은 경우
                if (max < map[r][c]) {
                    max = map[r][c];
                    tr = r;
                    tc = c;
                    continue;
                }

                // 이 아래는 공격력이 같은 경우만 있음

                if (time[r][c] > time[tr][tc]) continue;


                // 공격한지 더 오래된 경우
                if (time[r][c] < time[tr][tc]) {
                    tr = r;
                    tc = c;
                    continue;
                }

                // 이 아래는 공격력이 같고 마지막 공격 시간이 같음

                if (tc + tr > r + c) {
                    tr = r;
                    tc = c;
                    continue;
                }

                if (tr + tc < r + c) continue;

                if (tc > c) {
                    tr = r;
                    tc = c;
                }

            }
        }

    }

    static void findAttacker() {
        int min = Integer.MAX_VALUE;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                // 부서진 포탑이거나 공격력이 더 높은 경우
                if (map[r][c] <= 0 || min < map[r][c]) continue;

                // 1. 공격력이 더 낮은 경우
                if (map[r][c] < min) {
                    min = map[r][c];
                    ar = r;
                    ac = c;
                    continue;
                }

                // 이 아래는 공격력이 같은 경우만 있음

                // 이전에 공격한 경우
                if (time[r][c] < time[ar][ac]) continue;


                // 가장 최근에 공격한 경우
                if (time[r][c] > time[ar][ac]) {
                    ar = r;
                    ac = c;
                    continue;
                }

                // 이 아래는 공격력이 같고 마지막 공격 시간이 같음

                if (ar + ac < r + c) {
                    ar = r;
                    ac = c;
                    continue;
                }

                if (ar + ac > r + c) continue;

                if (ac < c) {
                    ar = r;
                    ac = c;
                }

            }
        }

        map[ar][ac] += N + M;
    }


    static void attack() {
        // 레이저
        boolean[][] visited = new boolean[N][M];
        Queue<Laser> q = new ArrayDeque<>();
        visited[ar][ac] = true;
        q.offer(new Laser(ar, ac));
        while (!q.isEmpty()) {
            Laser cur = q.poll();


            if (cur.r == tr && cur.c == tc) {

                map[tr][tc] -= map[ar][ac];

                int half = map[ar][ac] / 2;

                cur.posList.remove(cur.posList.size() - 1);

                for (int[] p : cur.posList) {
                    map[p[0]][p[1]] -= half;

                    used[p[0]][p[1]] = true;
                }

                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0) nr = N - 1;
                if (N <= nr) nr = 0;
                if (nc < 0) nc = M - 1;
                if (M <= nc) nc = 0;


                if (visited[nr][nc] || map[nr][nc] <= 0) continue;
                visited[nr][nc] = true;
                Laser next = new Laser(nr, nc);
                for (int[] p : cur.posList) {
                    next.posList.add(p);
                }
                next.posList.add(new int[]{nr, nc});
                q.offer(next);

            }
        }


        // 포탄 공격

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        int half = map[ar][ac] / 2;
        map[tr][tc] -= map[ar][ac];
        for (int d = 0; d < 8; d++) {
            int nr = tr + dr[d];
            int nc = tc + dc[d];

            if (nr < 0) nr = N - 1;
            if (N <= nr) nr = 0;
            if (nc < 0) nc = M - 1;
            if (M <= nc) nc = 0;

            if (nr == ar && nr == ac) continue;
            if (map[nr][nc] <= 0) continue;

            map[nr][nc] -= half;

            used[nr][nc] = true;
        }
    }

    static void recover() {

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (used[r][c] || map[r][c] <= 0) continue;
                map[r][c]++;
            }
        }

    }

    static void printMap() {
        System.out.println("printMap----------");
        for (int r = 0; r < N; r++) {

            for (int c = 0; c < M; c++) {
                System.out.print(map[r][c] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        time = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int t = 1; t <= K; t++) {

            // 공격자 선정
            findAttacker();
            time[ar][ac] = t;

//            printMap();
//            System.out.println("ar : " + ar + " ac : " + ac);
//            // 타겟 선정
            findTarget();

//            printMap();
//            System.out.println("tr : " + tr + " tc : " + tc);


            used = new boolean[N][M];
            used[ar][ac] = true;
            used[tr][tc] = true;

            // 공격
            attack();

            // 정비
            recover();
//            System.out.println("턴 종료----------");
//            printMap();

            if (onlyOne()) break;
        }

        System.out.println(maxPower());


    }

    static class Laser {
        int r, c;
        ArrayList<int[]> posList;

        public Laser(int r, int c) {
            this.r = r;
            this.c = c;
            posList = new ArrayList<>();
        }
    }
}
