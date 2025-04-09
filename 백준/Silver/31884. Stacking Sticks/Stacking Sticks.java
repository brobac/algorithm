import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        HashMap<Integer, Integer> map = new HashMap<>();
        while (Q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());

            if (q == 1) {
                int max = 0;
                for (int j = 0; j < 4; j++) {
                    if (map.containsKey(i + j)) {
                        max = Math.max(max, map.get(i + j));
                    }
                }
                for (int j = 0; j < 4; j++) {
                    map.put(i + j, max + 1);
                }
                continue;
            }

            if (q == 2) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 4);
                } else {
                    map.put(i, 4);
                }
                continue;
            }

            if (map.containsKey(i)) {
                sb.append(map.get(i)).append("\n");
            } else {
                sb.append("0\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}