import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;


            Map<String, String> manitto = new HashMap<>();
            Map<String, Boolean> used = new HashMap<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                manitto.put(a, b);
                used.put(a, false);
            }

            int count = 0;

            for (String name : manitto.keySet()) {
                if (used.get(name)) continue;

                String next = manitto.get(name);
                while (!next.equals(name)) {
                    used.put(next, true);
                    next = manitto.get(next);
                }

                count++;
            }
            sb.append(t++).append(" ").append(count).append("\n");
        }


        System.out.println(sb);
    }
}