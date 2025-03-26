import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static char[][] map;


    static void dfs(int r, int c, char op, int prev) {


        if (r == N - 1 && c == N - 1) {
            int v = calculate(prev, map[r][c] - '0', op);
            min = Math.min(min, v);
            max = Math.max(max, v);
            return;
        }

        if ((r + c) % 2 == 1) {
            if (r + 1 < N) {
                dfs(r + 1, c, map[r][c], prev);
            }
            if (c + 1 < N) {
                dfs(r, c + 1, map[r][c], prev);
            }
        } else {
            if (r + 1 < N) {
                dfs(r + 1, c, op, calculate(prev, map[r][c] - '0', op));
            }
            if (c + 1 < N) {
                dfs(r, c + 1, op, calculate(prev, map[r][c] - '0', op));
            }

        }

    }

    static int calculate(int prev, int cur, char op) {
        int result = prev;

        switch (op) {
            case '+':
                result += cur;
                break;

            case '-':
                result -= cur;
                break;

            case '*':
                result *= cur;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = st.nextToken().charAt(0);
            }
        }
        int start = map[0][0] - '0';

        dfs(0, 1, '.', start);
        dfs(1, 0, '.', start);
        System.out.println(max + " " + min);


    }
}