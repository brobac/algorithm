import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static int[] value;
    static int[][] clause;

    static void solution(int cnt) {
        if (cnt == N) {
            for (int[] c : clause) {
                boolean x1 = c[0] < 0 && value[c[0] * -1] == 0 || 0 < c[0] && value[c[0]] == 1;
                boolean x2 = c[1] < 0 && value[c[1] * -1] == 0 || 0 < c[1] && value[c[1]] == 1;

                if (x1 || x2) continue;
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("1\n");
            for (int i = 1; i <= N; i++) {
                sb.append(value[i]).append(" ");
            }

            System.out.println(sb);
            System.exit(0);
        }

        value[cnt + 1] = 1;
        solution(cnt + 1);
        value[cnt + 1] = 0;
        solution(cnt + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        value = new int[N + 1];
        clause = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            clause[i][0] = Integer.parseInt(st.nextToken());
            clause[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(0);
        System.out.println(0);
    }


}