import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int D, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        ArrayList<int[]> pipeList = new ArrayList<>();
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (D < L) continue;
            pipeList.add(new int[]{L, C});
        }
        int[] memo = new int[D + 1];
        for (int[] pipe : pipeList) {
            int l = pipe[0];
            int c = pipe[1];
            for (int i = D; l <= i; i--) {
                if (memo[i - l] != 0 && memo[i] < Math.min(c, memo[i - l])) {
                    memo[i] = Math.min(c, memo[i - l]);
                } else if (i == l && memo[l] < c) {
                    memo[l] = c;
                }
            }
        }

        System.out.println(memo[D]);

    }
}