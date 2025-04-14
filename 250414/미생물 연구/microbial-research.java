import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] board;
    static Paper[] paper;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || N <= c;
    }


    static boolean isSplitted(int n) {
        int count = 0;
        Paper p = paper[n];
        int minR = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxC = Integer.MIN_VALUE;
        ArrayList<int[]> nextList = new ArrayList<>();

        boolean[][] visited = new boolean[p.h][p.w];

        find:
        for (int r = 0; r < p.h; r++) {
            for (int c = 0; c < p.w; c++) {
                if (board[p.r + r][p.c + c] != n || visited[r][c]) continue;

                visited[r][c] = true;
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{r, c});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];

                    count++;
                    nextList.add(new int[]{cr, cc});
                    minR = Math.min(minR, p.r + cr);
                    maxR = Math.max(maxR, p.r + cr);
                    minC = Math.min(minC, p.c + cc);
                    maxC = Math.max(maxC, p.c + cc);

                    for (int d = 0; d < 4; d++) {
                        int nr = cr + dr[d];
                        int nc = cc + dc[d];


                        if (outOfMap(p.r + nr, p.c + nc) || board[p.r + nr][p.c + nc] != n || visited[nr][nc]) continue;

                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }

                break find;
            }
        }


        if (p.r != minR || p.c != minC) {
            nextList = new ArrayList<>();
            visited = new boolean[p.h][p.w];
            p.r = minR;
            p.c = minC;
            p.h = maxR - minR + 1;
            p.w = maxC - minC + 1;
            find:
            for (int r = 0; r < p.h; r++) {
                for (int c = 0; c < p.w; c++) {
                    if (board[p.r + r][p.c + c] != n || visited[r][c]) continue;

                    visited[r][c] = true;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{r, c});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int cr = cur[0];
                        int cc = cur[1];

                        nextList.add(new int[]{cr, cc});

                        for (int d = 0; d < 4; d++) {
                            int nr = cr + dr[d];
                            int nc = cc + dc[d];


                            if (outOfMap(p.r + nr, p.c + nc) || board[p.r + nr][p.c + nc] != n || visited[nr][nc])
                                continue;

                            visited[nr][nc] = true;
                            q.offer(new int[]{nr, nc});
                        }
                    }

                    break find;
                }
            }
            p.list = nextList;

        } else {
            p.r = minR;
            p.c = minC;
            p.h = maxR - minR + 1;
            p.w = maxC - minC + 1;
            p.list = nextList;
        }


        return p.size != count;
    }

    static void printBoard() {
        System.out.println("----- printBoard -----");
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    static void arrange(int n) {
        PriorityQueue<Paper> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (paper[i] != null) {
                pq.offer(paper[i]);
            }
        }

        int[][] nextBoard = new int[N][N];

        paperOrder:
        while (!pq.isEmpty()) {
            Paper p = pq.poll();

            for (int r = 0; r <= N - p.h; r++) {
                col:
                for (int c = 0; c <= N - p.w; c++) {
                    for (int[] pos : p.list) {
                        int nr = r + pos[0];
                        int nc = c + pos[1];
                        if (nextBoard[nr][nc] != 0) continue col;
                    }

                    for (int[] pos : p.list) {
                        int nr = r + pos[0];
                        int nc = c + pos[1];
                        nextBoard[nr][nc] = p.number;
                    }

                    p.r = r;
                    p.c = c;
                    continue paperOrder;
                }
            }

            paper[p.number] = null;
        }

        board = nextBoard;
    }

    static long view(int n) {
        long result = 0;

        boolean[][] adj = new boolean[K + 1][K + 1];

        for (int i = 1; i <= n; i++) {
            if (paper[i] == null) continue;

            Paper p = paper[i];

            for (int[] pos : p.list) {

                for (int d = 0; d < 4; d++) {
                    int nr = p.r + pos[0] + dr[d];
                    int nc = p.c + pos[1] + dc[d];

                    if (outOfMap(nr, nc) || board[nr][nc] == 0 || board[nr][nc] == p.number || adj[p.number][board[nr][nc]])
                        continue;

                    adj[p.number][board[nr][nc]] = true;
                    adj[board[nr][nc]][p.number] = true;

                    result += (long) p.size * paper[board[nr][nc]].size;

                }


            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        paper = new Paper[K + 1];


        for (int n = 1; n <= K; n++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int h = r2 - r1;
            int w = c2 - c1;
            int size = h * w;

            paper[n] = new Paper(r1, c1, h, w, size, n);

            for (int r = r1; r < r2; r++) {
                for (int c = c1; c < c2; c++) {
                    if (board[r][c] == 0) {
                        board[r][c] = n;
                        continue;
                    }

                    paper[board[r][c]].size--;
                    board[r][c] = n;

                }
            }


            for (int i = 1; i <= n; i++) {
                if (paper[i] == null) continue;
                if (paper[i].size == 0 || isSplitted(i)) {
                    paper[i] = null;
                }
            }


            arrange(n);


            sb.append(view(n)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static class Paper implements Comparable<Paper> {
        int r, c, h, w, size, number;
        ArrayList<int[]> list;

        public Paper(int r, int c, int h, int w, int size, int number) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.size = size;
            this.number = number;
            list = new ArrayList<>();
        }

        @Override
        public int compareTo(Paper o) {
            if (size == o.size) return number - o.number;
            return o.size - size;
        }

        @Override
        public String toString() {
            String info = "Paper{" +
                    "r=" + r +
                    ", c=" + c +
                    ", h=" + h +
                    ", w=" + w +
                    ", size=" + size +
                    ", number=" + number +
                    ", list.size() :  " + list.size() +
                    '}';

            StringBuilder sb = new StringBuilder();
            sb.append(info).append("\n");
//            for (int[] pos : list) {
//                sb.append(Arrays.toString(pos)).append("\n");
//            }
            return sb.toString();
        }
    }
}
