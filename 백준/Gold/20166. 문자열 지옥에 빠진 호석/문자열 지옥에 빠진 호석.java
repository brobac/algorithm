import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static char[][] map;
    static String word;
    static int temp;

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static void dfs(int r, int c, int i) {
        if (i == word.length()) {
            temp++;
            return;
        }

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0) {
                nr = (nr + N) % N;
            } else {
                nr %= N;
            }

            if (nc < 0) {
                nc = (nc + M) % M;
            } else {
                nc %= M;
            }

            char target = word.charAt(i);
            if (map[nr][nc] == target) {
                dfs(nr, nc, i + 1);
            }


        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int r = 0; r < N; r++) {
            map[r] = br.readLine().toCharArray();
        }

        Map<String, Integer> counts = new HashMap<>();

        for (int i = 0; i < K; i++) {
            word = br.readLine();
            if (counts.containsKey(word)) {
                sb.append(counts.get(word)).append("\n");
                continue;
            }
            int count = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (word.charAt(0) == map[r][c]) {
                        temp = 0;
                        dfs(r, c, 1);
                        count += temp;
                    }
                }
            }
            counts.put(word, count);
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}