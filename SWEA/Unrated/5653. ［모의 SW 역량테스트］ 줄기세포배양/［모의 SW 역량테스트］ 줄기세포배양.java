import java.io.*;
import java.util.*;

public class Solution {
    static final int MAX_N = 50, MAX_M = 50, MAX_K = 300;
    static int N, M, K;
    static Cell[][] map;
    static Queue<Cell> q;
    static int[] active;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void printMap() {
        System.out.println("print Map");
        for (int r = 0; r < 350; r++) {
            for (int c = 0; c < 350; c++) {
                if (map[r][c] == null) {
                    System.out.print("0 ");
                    continue;
                }
                if (map[r][c].isDead) {
                    System.out.print("X ");
                    continue;
                }
                if (map[r][c].isActive) {
                    System.out.print(map[r][c].x + "! ");
                    continue;
                }
                System.out.print(map[r][c].x + " ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            map = new Cell[MAX_N + MAX_K][MAX_M + MAX_K];
            q = new ArrayDeque<>();
            active = new int[12];

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 0) continue;
                    Cell cell = new Cell();
                    cell.r = MAX_K / 2 + r;
                    cell.c = MAX_K / 2 + c;
                    cell.x = x;
                    map[MAX_K / 2 + r][MAX_K / 2 + c] = cell;
                    q.offer(cell);
                }
            }


            for (int k = 1; k <= K; k++) {

                Map<String, Integer> next = new HashMap<>();
                Queue<Cell> nextQ = new ArrayDeque<>();

                for (int i = 1; i <= 10; i++) {
                    active[i] = active[i + 1];
                }

                while (!q.isEmpty()) {
                    Cell c = q.poll();


                    if (c.isActive) {
                        for (int d = 0; d < 4; d++) {
                            int nr = c.r + dr[d];
                            int nc = c.c + dc[d];

                            if (map[nr][nc] != null) continue;
                            String key = nr + " " + nc;
                            next.put(key, Math.max(next.getOrDefault(key, 0), c.x));

                        }
                        c.isActive = false;

                        active[c.x - 1]++;

                    } else {
                        c.t++;
                        if (c.t == c.x) {
                            c.isActive = true;
                        }
                        nextQ.offer(c);
                    }
                }

                for (Map.Entry<String, Integer> e : next.entrySet()) {
                    st = new StringTokenizer(e.getKey());
                    Cell cell = new Cell();
                    cell.r = Integer.parseInt(st.nextToken());
                    cell.c = Integer.parseInt(st.nextToken());
                    cell.x = e.getValue();
                    map[cell.r][cell.c] = cell;
                    nextQ.offer(cell);


                }
                q = nextQ;

//                Iterator<Cell> iterator = q.iterator();
//                System.out.println(k + "시간 경과 다음에 들어갈 Cell들은? " + q.size() + "개");
//                while (iterator.hasNext()) {
//                    System.out.println(iterator.next());
//                }


            }


            StringBuilder sb = new StringBuilder();
            int count = q.size();
            for (int i = 1; i <= 10; i++) {
                count += active[i];
            }
            sb.append("#").append(t).append(" ").append(count).append("\n");
            bw.write(sb.toString());
        }

        bw.flush();
    }

    static class Cell {
        int r, c, x, t;
        boolean isDead, isActive;

        @Override
        public String toString() {
            return "Cell{" +
                    "r=" + r +
                    ", c=" + c +
                    ", x=" + x +
                    ", t=" + t +
                    ", isDead=" + isDead +
                    ", isActive=" + isActive +
                    '}';
        }
    }
}
