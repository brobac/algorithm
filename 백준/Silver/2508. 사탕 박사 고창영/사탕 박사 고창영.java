import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (; 0 < T; T--) {
            br.readLine();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            char[][] map = new char[R][C];
            boolean[][] visited = new boolean[R][C];
            for (int r = 0; r < R; r++) {
                map[r] = br.readLine().toCharArray();
            }

            int count = 0;
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (visited[r][c]) continue;

                    if (c < C - 2 && map[r][c] == '>' && map[r][c + 1] == 'o' && map[r][c + 2] == '<') {
                        visited[r][c + 1] = true;
                        visited[r][c + 2] = true;
                        count++;
                    } else if (r < R - 2 && map[r][c] == 'v' && map[r + 1][c] == 'o' && map[r + 2][c] == '^') {
                        visited[r + 1][c] = true;
                        visited[r + 2][c] = true;
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);
    }
}