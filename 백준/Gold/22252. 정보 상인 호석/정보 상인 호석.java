import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        long result = 0;
        Map<String, Gorilla> map = new HashMap<>();
        for (int q = 0; q < Q; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if (op == 1) {
                String name = st.nextToken();
                Gorilla g = map.getOrDefault(name, new Gorilla());
                int k = Integer.parseInt(st.nextToken());
                for (int i = 0; i < k; i++) {
                    long c = Long.parseLong(st.nextToken());
                    g.infoQ.add(c);
                    g.total += c;
                }
                map.put(name, g);
            } else {
                String name = st.nextToken();
                int b = Integer.parseInt(st.nextToken());
                Gorilla g = map.get(name);
                if (g == null) continue;
                if (g.infoQ.size() <= b) {
                    result += g.total;
                    g.total = 0;
                    g.infoQ.clear();
                } else {
                    for (int i = 0; i < b; i++) {
                        long v = g.infoQ.poll();
                        g.total -= v;
                        result += v;
                    }
                }
            }
        }

        System.out.println(result);
    }

    static class Gorilla {
        PriorityQueue<Long> infoQ;
        long total;

        public Gorilla() {
            this.infoQ = new PriorityQueue<>(Comparator.reverseOrder());
            this.total = 0;
        }
    }
}