import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            double v = Double.parseDouble(st.nextToken());
            list.add(new Pair(i, Math.sqrt(x * x + y * y) / v));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Pair p : list) {
            sb.append(p.id).append("\n");
        }
        System.out.println(sb);
    }

    static class Pair implements Comparable<Pair> {
        int id;
        double value;

        public Pair(int id, double value) {
            this.id = id;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            if (value == o.value) return id - o.id;
            return value < o.value ? -1 : 1;
        }

    }
}