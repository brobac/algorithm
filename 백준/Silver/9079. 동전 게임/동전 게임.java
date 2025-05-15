import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] turn = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        tc:
        while (T-- > 0) {
            int[] coin = new int[9];
            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    coin[i * 3 + j] = st.nextToken().equals("H") ? 1 : 0;
                }
            }
            int v = coin[0];
            for (int i = 1; i < 9; i++) {
                v = v << 1;
                v = v | coin[i];
            }

            Set<Integer> set = new HashSet<>();
            set.add(v);

            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{v, 0});
            while (!q.isEmpty()) {
                int[] cur = q.poll();

                int c = cur[0];
                int time = cur[1];


                if (c == 0 || c == 511) {
                    sb.append(time).append("\n");
                    continue tc;
                }


                for (int[] t : turn) {
                    int next = c;
                    for (int i = 0; i < 3; i++) {
                        next ^= (1 << (8 - t[i]));

                    }

                    if (set.contains(next)) continue;

                    set.add(next);
                    q.offer(new int[]{next, time + 1});
                }
            }

            sb.append("-1\n");
        }

        System.out.println(sb);
    }
}