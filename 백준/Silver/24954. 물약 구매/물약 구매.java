import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[] c, order;
    static int[][] d;
    static boolean[] selected;

    static void solution(int cnt) {
        if (cnt == N) {
            int[] cost = Arrays.copyOf(c, N + 1);

            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += cost[order[i]];
                for (int j = 1; j <= N; j++) {
                    int next = cost[j] - d[order[i]][j];
                    if (next <= 0) {
                        cost[j] = 1;
                    } else {
                        cost[j] = next;
                    }
                }
            }

            result = Math.min(result, sum);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            order[cnt] = i;
            solution(cnt + 1);
            selected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        c = new int[N + 1];
        d = new int[N + 1][N + 1];
        selected = new boolean[N + 1];
        order = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int p = Integer.parseInt(br.readLine());
            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                d[i][a] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0);
        System.out.println(result);

    }
}