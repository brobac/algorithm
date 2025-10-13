import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int minCoke = Integer.MAX_VALUE;
        int maxBugger = 0;

        for (int i = 0; i <= T / N; i++) {
            int mBugger = (T - N * i) / M;
            int coke = (T - N * i) - mBugger * M;

            if (coke < minCoke) {
                minCoke = coke;
                maxBugger = i + mBugger;
            } else if (coke == minCoke && maxBugger < i + mBugger) {
                maxBugger = i + mBugger;
            }
        }

        System.out.println(maxBugger + " " + minCoke);
    }
}