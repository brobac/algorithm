import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Character> list = new ArrayList<>();
            for (char c : br.readLine().toCharArray()) {
                list.add(c);
            }
            int idx = 0;
            while (idx < list.size() - 2) {
                if (list.get(idx) == 'A' && list.get(idx + 1) == 'B' && list.get(idx + 2) == 'B') {
                    list.remove(idx + 2);
                    list.set(idx, 'B');
                    list.set(idx + 1, 'A');
                    if (2 <= idx) {
                        idx -= 2;
                    }
                    continue;
                }
                idx++;
            }

            for (char c : list) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}