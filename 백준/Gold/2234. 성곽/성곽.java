import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static boolean[][][] wall;


    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || R <= r || C <= c;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        wall = new boolean[R][C][4];
        int[] w = {1, 2, 4, 8};


        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                int v = Integer.parseInt(st.nextToken());
                for (int d = 0; d < 4; d++) {
                    wall[r][c][d] = 0 < (v & w[d]);
                }
            }
        }

        int[][] map = new int[R][C];

        int roomNumber = 0;

        boolean[][] visited = new boolean[R][C];

        ArrayList<Integer> roomSize = new ArrayList<>();
        int maxRoomSize = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (visited[r][c]) continue;
                visited[r][c] = true;
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{r, c});
                int size = 0;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];

                    map[cr][cc] = roomNumber;
                    size++;

                    for (int d = 0; d < 4; d++) {
                        if (wall[cr][cc][d]) continue;

                        int nr = cr + dr[d];
                        int nc = cc + dc[d];

                        if (outOfMap(nr, nc) || visited[nr][nc]) continue;

                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }

                roomSize.add(size);
                maxRoomSize = Math.max(maxRoomSize, size);
                roomNumber++;
            }
        }

        int maxSumSize = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (outOfMap(nr, nc) || map[r][c] == map[nr][nc]) continue;

                    maxSumSize = Math.max(maxSumSize, roomSize.get(map[r][c]) + roomSize.get(map[nr][nc]));

                }
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(roomSize.size()).append("\n").append(maxRoomSize).append("\n").append(maxSumSize);

        System.out.println(sb);
    }
}