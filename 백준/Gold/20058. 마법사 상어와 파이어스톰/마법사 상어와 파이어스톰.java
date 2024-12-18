import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, Q, size;
    static int[][] map;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || size <= r || size <= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, N);

        map = new int[size][size];

        for (int r = 0; r < size; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < size; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        for (int q = 0; q < Q; q++) {
            int L = Integer.parseInt(st.nextToken());

            int[][] temp = new int[size][size];

            int unit = (int) Math.pow(2, L);
            for (int rs = 0; rs < size; rs += unit) {
                for (int cs = 0; cs < size; cs += unit) {

                    for (int r = 0; r < unit; r++) {
                        for (int c = 0; c < unit; c++) {
                            temp[rs + c][cs + unit - r - 1] = map[rs + r][cs + c];
                        }
                    }
                }
            }
            map = temp;

            temp = new int[size][size];
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {

                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (outOfMap(nr, nc) || map[nr][nc] == 0) continue;
                        count++;
                    }

                    temp[r][c] = 3 <= count ? map[r][c] : map[r][c] == 0 ? 0 : map[r][c] - 1;

                }
            }
            map = temp;
        }

        int sum = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                sum += map[r][c];
            }
        }

        int maxCount = 0;
        boolean[][] visited = new boolean[size][size];

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (visited[r][c] || map[r][c] == 0) continue;

                int count = 1;
                Queue<int[]> q = new ArrayDeque<>();
                visited[r][c] = true;
                q.offer(new int[]{r, c});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];


                    for (int d = 0; d < 4; d++) {
                        int nr = cr + dr[d];
                        int nc = cc + dc[d];
                        if (outOfMap(nr, nc) || map[nr][nc] == 0 || visited[nr][nc]) continue;
                        count++;
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }

                }
                maxCount = Math.max(maxCount, count);
            }
        }


        System.out.println(sum);
        System.out.println(maxCount);
    }
}