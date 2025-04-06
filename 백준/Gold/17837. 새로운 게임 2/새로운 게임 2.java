import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static final int WHITE = 0, RED = 1, BLUE = 2;
    static int N, K;
    static Deque<Piece>[][] map;
    static int[][] color;
    static Piece[] pieces;

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 체스판 만들기
        map = new Deque[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = new ArrayDeque<>();
            }
        }

        // 체스판 색
        color = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                color[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        //말의 위치를 저장하고 체스판에 말을 올린다.
        pieces = new Piece[K + 1];
        for (int number = 1; number <= K; number++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            Piece p = new Piece(number, r, c, d);
            pieces[number] = p;
            map[r][c].push(p);

        }
    }

    static int reverse(int d) {
        if (d == 0) return 1;
        if (d == 1) return 0;
        if (d == 2) return 3;
        if (d == 3) return 2;
        return 0;
    }

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || N <= c;
    }


    // 종료 시 true 리턴
    static boolean game() {
        for (int number = 1; number <= K; number++) {


            int r = pieces[number].r;
            int c = pieces[number].c;
            int d = pieces[number].d;

            int nr = r + dr[d];
            int nc = c + dc[d];

            if (outOfMap(nr, nc) || color[nr][nc] == BLUE) {

                pieces[number].d = reverse(d);

                nr = r + dr[pieces[number].d];
                nc = c + dc[pieces[number].d];

                if (outOfMap(nr, nc) || color[nr][nc] == BLUE) {
                    continue;
                }


                if (color[nr][nc] == RED) {
                    while (map[r][c].peek().number != number) {
                        Piece p = map[r][c].pop();
                        p.r = nr;
                        p.c = nc;
                        map[nr][nc].push(p);
                    }
                    Piece p = map[r][c].pop();
                    p.r = nr;
                    p.c = nc;
                    map[nr][nc].push(p);


                    if (4 <= map[nr][nc].size()) return true;

                    continue;
                }

                ArrayDeque<Piece> temp = new ArrayDeque<>();
                while (map[r][c].peek().number != number) {
                    Piece p = map[r][c].pop();
                    p.r = nr;
                    p.c = nc;
                    temp.push(p);
                }
                Piece p = map[r][c].pop();
                p.r = nr;
                p.c = nc;
                map[nr][nc].push(p);
                while (!temp.isEmpty()) {
                    map[nr][nc].push(temp.pop());
                }

                if (4 <= map[nr][nc].size()) return true;


                continue;
            }

            if (color[nr][nc] == RED) {
                while (map[r][c].peek().number != number) {
                    Piece p = map[r][c].pop();
                    p.r = nr;
                    p.c = nc;
                    map[nr][nc].push(p);
                }
                Piece p = map[r][c].pop();
                p.r = nr;
                p.c = nc;
                map[nr][nc].push(p);


                if (4 <= map[nr][nc].size()) return true;

                continue;
            }

            ArrayDeque<Piece> temp = new ArrayDeque<>();
            while (map[r][c].peek().number != number) {
                Piece p = map[r][c].pop();
                p.r = nr;
                p.c = nc;
                temp.push(p);
            }
            Piece p = map[r][c].pop();
            p.r = nr;
            p.c = nc;
            map[nr][nc].push(p);
            while (!temp.isEmpty()) {
                map[nr][nc].push(temp.pop());
            }

            if (4 <= map[nr][nc].size()) return true;


        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        init();

        int result = -1;

        for (int i = 1; i <= 1000; i++) {
            boolean end = game();
            if (end) {
                result = i;
                break;
            }
        }

        System.out.println(result);

    }


    static class Piece {
        int number, r, c, d;

        public Piece(int number, int r, int c, int d) {
            this.number = number;
            this.r = r;
            this.c = c;
            this.d = d;
        }


        @Override
        public String toString() {
            return "Piece{" +
                    "number=" + number +
                    ", r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    '}';
        }
    }
}
