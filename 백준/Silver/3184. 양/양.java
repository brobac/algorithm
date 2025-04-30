import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean outOfMap(int r, int c) {
        return r < 0 || c < 0 || R <= r || C <= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];

        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        int sheepResult = 0;
        int wolfResult = 0;

        boolean[][] visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j] || map[i][j] == '#') continue;
                visited[i][j] = true;
                int sheep = map[i][j] == 'o' ? 1 : 0;
                int wolf = map[i][j] == 'v' ? 1 : 0;

                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{i, j});

                while (!q.isEmpty()) {
                    int[] cur = q.poll();

                    int r = cur[0];
                    int c = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (outOfMap(nr, nc) || visited[nr][nc] || map[nr][nc] == '#') continue;

                        if (map[nr][nc] == 'o') {
                            sheep++;
                        } else if (map[nr][nc] == 'v') {
                            wolf++;
                        }
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }

                if (wolf < sheep) {
                    sheepResult += sheep;
                } else {
                    wolfResult += wolf;
                }
            }
        }

        System.out.println(sheepResult + " " + wolfResult);
    }
}