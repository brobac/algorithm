import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<List<Integer>> list = new ArrayList<>();
            int[] prize = new int[N];
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> requireList = new ArrayList<>();
                st = new StringTokenizer(br.readLine());
                int K = Integer.parseInt(st.nextToken());
                for (int j = 0; j < K; j++) {
                    requireList.add(Integer.parseInt(st.nextToken()));
                }
                list.add(requireList);
                prize[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] sticker = new int[M + 1];
            for (int i = 1; i <= M; i++) {
                sticker[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;

            for (int i = 0; i < N; i++) {
                List<Integer> requireList = list.get(i);

                change:
                while (true) {
                    for (int v : requireList) {
                        if (sticker[v] == 0) break change;
                    }
                    for (int v : requireList) {
                        sticker[v]--;
                    }
                    sum += prize[i];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }
}
