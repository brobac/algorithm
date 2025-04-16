import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> inCount = new HashMap<>();
        Map<String, List<String>> ancestor = new HashMap<>();
        Map<String, Set<String>> children = new TreeMap<>();
        Set<String> root = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String name = st.nextToken();
            inCount.put(name, 0);
            ancestor.put(name, new ArrayList<>());
            children.put(name, new TreeSet<>());
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String X = st.nextToken();
            String Y = st.nextToken();

            inCount.put(Y, inCount.get(Y) + 1);
            ancestor.get(X).add(Y);


        }

        Queue<String> q = new ArrayDeque<>();

        for (Map.Entry<String, Integer> entry : inCount.entrySet()) {
            if (entry.getValue() == 0) {
                q.offer(entry.getKey());
            }
        }

        while (!q.isEmpty()) {
            String cur = q.poll();

            if (ancestor.get(cur).isEmpty()) {
                root.add(cur);
                continue;
            }

            for (String p : ancestor.get(cur)) {
                inCount.put(p, inCount.get(p) - 1);

                children.get(p).add(cur);
                for (String c : children.get(cur)) {
                    children.get(p).remove(c);
                }

                if (inCount.get(p) == 0) {
                    q.offer(p);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(root.size()).append("\n");

        for (String s : root) {
            sb.append(s).append(" ");
        }

        for (Map.Entry<String, Set<String>> entry : children.entrySet()) {
            sb.append("\n").append(entry.getKey()).append(" ").append(entry.getValue().size());
            for (String s : entry.getValue()) {
                sb.append(" ").append(s);
            }
        }


        System.out.println(sb);

    }
}