import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Float> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < 7; i++) {
            list.add(Float.parseFloat(br.readLine()));
        }
        Collections.sort(list);

        for (int i = 7; i < N; i++) {
            float num = Float.parseFloat(br.readLine());
            int idx = 7;
            while (0 < idx) {
                if (list.get(idx - 1) <= num) break;
                idx--;
            }

            if (idx == 7) continue;
            list.add(idx, num);
            list.remove(7);
        }


        StringBuilder sb = new StringBuilder();
        for (float v : list) {
            sb.append(String.format("%.3f", v)).append("\n");
        }
        System.out.println(sb);
    }
}