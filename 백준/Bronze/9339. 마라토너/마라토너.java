import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (; 0 < T; T--) {
            int K = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            int bestN = 0;
            int bestTime = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                if (!set.contains(n) || h == -1) continue;

                int time = h * 60 + m;
                if (time <= 360) count++;
                if (time < bestTime) {
                    bestTime = time;
                    bestN = n;
                }
            }

            sb.append(bestN).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}