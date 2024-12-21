import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] != 'S') continue;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 0 || nc < 0 || R <= nr || C <= nc) continue;

                    if (map[nr][nc] == 'W') {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1\n");
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(map[r][c] == '.' ? 'D' : map[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}