import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M, S, sr, sc;

    static ArrayList<Integer>[][] map, keep;
    static int[][] smell;

    static int[] fishR = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] fishC = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] sharkR = {-1, 0, 1, 0};
    static int[] sharkC = {0, -1, 0, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || 4 <= r || 4 <= c;
    }


    // 1. 복제 마법 시전
    static void copy() {
        keep = new ArrayList[4][4];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                keep[r][c] = new ArrayList<>();
                for (int v : map[r][c]) {
                    keep[r][c].add(v);
                }
            }
        }
    }

    // 2. 물고기 이동

    static void fishMove() {
        ArrayList<Integer>[][] temp = new ArrayList[4][4];

        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                temp[r][c] = new ArrayList<>();
            }
        }


        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {

                for (int v : map[r][c]) {
                    int nr = r;
                    int nc = c;
                    int nd = v;

                    for (int i = 0; i < 8; i++) {
                        int td = (v - i + 8) % 8;
                        int tr = r + fishR[td];
                        int tc = c + fishC[td];

                        // 격자밖이거나, 냄새나거나, 상어가있으면 안돼
                        if (outOfMap(tr, tc) || 0 < smell[tr][tc] || (tr == sr && tc == sc)) continue;

                        nr = tr;
                        nc = tc;
                        nd = td;
                        break;
                    }

                    temp[nr][nc].add(nd);
                }


            }
        }

        map = temp;

    }

    // 3. 상어 이동

    static void sharkMove() {
        int maxCount = -1;
        int[] move = new int[3];
        for (int i = 0; i < 4; i++) {
            int r1 = sr + sharkR[i];
            int c1 = sc + sharkC[i];

            if (outOfMap(r1, c1)) continue;
            for (int j = 0; j < 4; j++) {
                int r2 = r1 + sharkR[j];
                int c2 = c1 + sharkC[j];
                if (outOfMap(r2, c2)) continue;
                for (int k = 0; k < 4; k++) {
                    int r3 = r2 + sharkR[k];
                    int c3 = c2 + sharkC[k];
                    if (outOfMap(r3, c3)) continue;

                    int count = map[r1][c1].size() + map[r2][c2].size();
                    if ((r3 != r1 || c3 != c1) && (r3 != r2 || c3 != c2)) {
                        count += map[r3][c3].size();
                    }

                    if (maxCount < count) {
                        maxCount = count;
                        move[0] = i;
                        move[1] = j;
                        move[2] = k;
                    }


                }
            }


        }
        int r = sr;
        int c = sc;


        for (int d : move) {
            r += sharkR[d];
            c += sharkC[d];
            if (!map[r][c].isEmpty()) {
                smell[r][c] = 3;
                map[r][c].clear();
            }

        }
        sr = r;
        sc = c;


    }

    // 4. 냄새 제거

    static void removeSmell() {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (0 < smell[r][c]) smell[r][c]--;
            }
        }
    }

    //5. 복제
    static void paste() {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                for (int v : keep[r][c]) {
                    map[r][c].add(v);
                }
            }
        }
    }

    static void printFishCount() {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                System.out.print(map[r][c].size() + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        smell = new int[4][4];
        map = new ArrayList[4][4];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                map[r][c] = new ArrayList<>();
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            map[r][c].add(d);
        }
        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < S; i++) {
            copy();
            fishMove();
            sharkMove();
            removeSmell();
            paste();
        }

        int result = 0;


        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                result += map[r][c].size();
            }
        }

        System.out.println(result);

    }
}
