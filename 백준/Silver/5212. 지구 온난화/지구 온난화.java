import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R, C;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R + 2][C + 2];
        char[][] tempMap = new char[R + 2][C + 2];
        for (int i = 0; i <= R + 1; i++) {
            Arrays.fill(map[i], '.');
            Arrays.fill(tempMap[i], '.');
        }

        for (int r = 1; r <= R; r++) {
            char[] line = br.readLine().toCharArray();
            for (int c = 1; c <= C; c++) {
                map[r][c] = line[c - 1];
                tempMap[r][c] = line[c - 1];
            }
        }


        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (map[r][c] == '.') continue;

                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (map[nr][nc] == '.') count++;
                }

                if (3 <= count) {
                    tempMap[r][c] = '.';
                }
            }
        }

        int minR = R;
        int minC = C;
        int maxR = 0;
        int maxC = 0;
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (tempMap[r][c] == '.') continue;

                minR = Math.min(minR, r);
                minC = Math.min(minC, c);
                maxR = Math.max(maxR, r);
                maxC = Math.max(maxC, c);
            }
        }

        int resultR = maxR - minR + 1;
        int resultC = maxC - minC + 1;
        char[][] result = new char[resultR][resultC];

        for (int r = 0; r < resultR; r++) {
            for (int c = 0; c < resultC; c++) {
                result[r][c] = tempMap[r + minR][c + minC];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < resultR; r++) {
            for (int c = 0; c < resultC; c++) {
                sb.append(result[r][c]);
            }
            sb.append("\n");
        }


        System.out.println(sb);
    }
}