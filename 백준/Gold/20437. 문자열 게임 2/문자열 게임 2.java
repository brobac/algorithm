import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            ArrayList<Integer>[] list = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                list[i] = new ArrayList<>();
            }
            char[] W = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < W.length; i++) {
                list[W[i] - 'a'].add(i);
            }
            boolean valid = false;
            for (ArrayList<Integer> l : list) {
                if (K <= l.size()) {
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                sb.append("-1\n");
                continue;
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (ArrayList<Integer> l : list) {
                if (l.size() < K) continue;
                for (int i = 0; i <= l.size() - K; i++) {
                    int length = l.get(i + K - 1) - l.get(i) + 1;
                    min = Math.min(min, length);
                    max = Math.max(max, length);
                }
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}