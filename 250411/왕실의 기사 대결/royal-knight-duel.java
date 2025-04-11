import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, N, Q;
    static int[][] board, knightBoard;

    static ArrayList<Integer> list;
    static boolean[] used;

    static Knight[] knights;
    // 위, 오른, 아래, 왼
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};


    static void printBoard() {
        System.out.println("----- board -----");
        for (int r = 1; r <= L; r++) {
            for (int c = 1; c <= L; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    static void printKnightBoard() {
        System.out.println("----- knightBoard -----");
        for (int r = 1; r <= L; r++) {
            for (int c = 1; c <= L; c++) {
                System.out.print(knightBoard[r][c] + " ");
            }
            System.out.println();
        }
    }


    static int score() {
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (0 < knights[i].remainHp) {
                result += knights[i].hp - knights[i].remainHp;
            }
        }
        return result;
    }


    static boolean movableCheck(int nr, int nc) {
        if (board[nr][nc] == 2) return false;

        int nextKnight = knightBoard[nr][nc];
        if (0 < nextKnight && !used[nextKnight]) {
            used[nextKnight] = true;
            list.add(nextKnight);
        }
        return true;
    }

    static void move(int k, int d) {
        Knight knight = knights[k];
        switch (d) {
            case 0: {
                for (int c = knight.c; c < knight.c + knight.w; c++) {
                    // 위쪽 추가
                    knightBoard[knight.r - 1][c] = k;
                    // 아랫쪽 제거
                    knightBoard[knight.r + knight.h - 1][c] = 0;
                }

                knights[k].r--;

                break;
            }
            case 1: {
                for (int r = knight.r; r < knight.r + knight.h; r++) {
                    // 오른쪽 추가
                    knightBoard[r][knight.c + knight.w] = k;

                    // 왼쪽 체거
                    knightBoard[r][knight.c] = 0;
                }

                knights[k].c++;
                break;

            }
            case 2: {
                for (int c = knight.c; c < knight.c + knight.w; c++) {


                    // 아래쪽 추가
                    knightBoard[knight.r + knight.h][c] = k;

                    //위쪽 제거
                    knightBoard[knight.r][c] = 0;

                }
                knights[k].r++;
                break;
            }
            case 3: {
                for (int r = knight.r; r < knight.r + knight.h; r++) {

                    //왼쪽 추가
                    knightBoard[r][knight.c - 1] = k;

                    //오른쪽 제거
                    knightBoard[r][knight.c + knight.w - 1] = 0;

                }
                knights[k].c--;
                break;
            }
        }
    }

    static void damage(int k) {
        for (int r = knights[k].r; r < knights[k].r + knights[k].h; r++) {
            for (int c = knights[k].c; c < knights[k].c + knights[k].w; c++) {
                if (board[r][c] == 1) {
                    knights[k].remainHp--;

                    if (knights[k].remainHp == 0) {
                        removeKnight(k);
                        return;
                    }
                }
            }
        }

    }

    static void removeKnight(int k) {
        for (int r = knights[k].r; r < knights[k].r + knights[k].h; r++) {
            for (int c = knights[k].c; c < knights[k].c + knights[k].w; c++) {
                knightBoard[r][c] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        board = new int[L + 2][L + 2];
        knightBoard = new int[L + 2][L + 2];
        knights = new Knight[N + 1];

        for (int i = 0; i < L + 2; i++) {
            Arrays.fill(board[i], 2);
        }

        for (int r = 1; r <= L; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= L; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            knights[n] = new Knight(r, c, h, w, k, k);

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    knightBoard[r + i][c + j] = n;
                }
            }

        }


        order:
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (knights[i].remainHp <= 0) continue;

            list = new ArrayList<>();
            used = new boolean[N + 1];
            used[i] = true;
            list.add(i);

            for (int n = 0; n < list.size(); n++) {

                Knight knight = knights[list.get(n)];

                switch (d) {
                    case 0: {
                        for (int c = knight.c; c < knight.c + knight.w; c++) {
                            int nr = knight.r - 1;
                            int nc = c;

                            if (!movableCheck(nr, nc)) continue order;
                        }

                        break;
                    }
                    case 1: {
                        for (int r = knight.r; r < knight.r + knight.h; r++) {
                            int nr = r;
                            int nc = knight.c + knight.w;

                            if (!movableCheck(nr, nc)) continue order;
                        }
                        break;

                    }
                    case 2: {
                        for (int c = knight.c; c < knight.c + knight.w; c++) {
                            int nr = knight.r + knight.h;
                            int nc = c;

                            if (!movableCheck(nr, nc)) continue order;
                        }
                        break;
                    }
                    case 3: {
                        for (int r = knight.r; r < knight.r + knight.h; r++) {
                            int nr = r;
                            int nc = knight.c - 1;

                            if (!movableCheck(nr, nc)) continue order;
                        }
                        break;
                    }
                }

            }

            for (int n = list.size() - 1; 0 <= n; n--) {
                move(list.get(n), d);
            }

            for (int n = 1; n < list.size(); n++) {
                damage(list.get(n));
            }
        }

        System.out.println(score());


    }

    static class Knight {
        int r, c, h, w, hp, remainHp;

        public Knight(int r, int c, int h, int w, int hp, int remainHp) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.hp = hp;
            this.remainHp = remainHp;
        }
    }
}
