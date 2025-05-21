import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> ball = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            ball.put(v, ball.getOrDefault(v, 0) + 1);
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int ac = Integer.parseInt(st.nextToken());
            Map<Integer, Integer> a = new HashMap<>();
            for (int j = 0; j < ac; j++) {
                int v = Integer.parseInt(st.nextToken());
                a.put(v, a.getOrDefault(v, 0) + 1);
            }
            boolean eatable = true;
            for (Map.Entry<Integer, Integer> entry : a.entrySet()) {
                int k = entry.getKey();
                int count = entry.getValue();
                if (!ball.containsKey(k) || ball.get(k) < count) {
                    eatable = false;
                }
            }

            if (!eatable) {
                br.readLine();
                continue;
            }
            for (Map.Entry<Integer, Integer> entry : a.entrySet()) {
                int k = entry.getKey();
                int count = entry.getValue();

                ball.put(k, ball.get(k) - count);
            }

            st = new StringTokenizer(br.readLine());
            int bc = Integer.parseInt(st.nextToken());
            for (int j = 0; j < bc; j++) {
                int v = Integer.parseInt(st.nextToken());
                ball.put(v, ball.getOrDefault(v, 0) + 1);
            }

        }


        int total = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (Map.Entry<Integer, Integer> entry : ball.entrySet()) {
            int k = entry.getKey();
            int count = entry.getValue();
            total += count;
            for (int i = 0; i < count; i++) {
                sb.append(k).append(" ");
            }
        }

        System.out.println(total == 0 ? 0 : total + sb.toString());

    }
}