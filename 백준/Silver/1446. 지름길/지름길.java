import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] res = new int[D + 1];
        List<List<int[]>> shortcutList = new ArrayList<>();
        for (int i = 0; i <= D; i++) {
            shortcutList.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if (D < end || end - start < length) continue;
            shortcutList.get(end).add(new int[]{start, length});

        }

        for (int i = 1; i <= D; i++) {
            res[i] = res[i - 1] + 1;
            for (int[] shortcut : shortcutList.get(i)) {
                int start = shortcut[0];
                int length = shortcut[1];

                res[i] = Math.min(res[i], res[start] + length);
            }
        }

        System.out.println(res[D]);
    }
}
