import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result, emptyCount;
    static int[][] map;
    static ArrayList<int[]> spotList;
    static int[][] selected;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || N <= r || N <= c;
    }


    static void solution(int cnt, int start) {
        if (cnt == M) {
            int[][] visitTime = new int[N][N];
            int empty = emptyCount;
            Queue<int[]> q = new ArrayDeque<>();
            for (int[] pos : selected) {
                q.offer(pos);
                visitTime[pos[0]][pos[1]] = 1;
            }
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int t = visitTime[r][c];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (outOfMap(nr, nc) || map[nr][nc] == 1 || (visitTime[nr][nc] != 0 && visitTime[nr][nc] <= t + 1)) {
                        continue;
                    }
                    empty--;
                    if (empty == 0) {
                        result = Math.min(result, t);
                        break;
                    }
                    visitTime[nr][nc] = t + 1;
                    q.offer(new int[]{nr, nc});

                }
            }
            return;
        }

        for (int i = start; i < spotList.size(); i++) {
            selected[cnt][0] = spotList.get(i)[0];
            selected[cnt][1] = spotList.get(i)[1];
            solution(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = Integer.MAX_VALUE;
        map = new int[N][N];
        selected = new int[M][2];
        spotList = new ArrayList<>();
        emptyCount = 0;

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 2) {
                    spotList.add(new int[]{r, c});
                } else if (map[r][c] == 0) {
                    emptyCount++;
                }
            }
        }
        emptyCount += spotList.size() - M;
        
        if (emptyCount == 0) {
            System.out.println(0);
            return;
        }


        solution(0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }
}