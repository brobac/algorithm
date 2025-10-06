import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int MAX = 1_000_000_000;

        List<Integer> f = new ArrayList<>();
        f.add(1);
        int a = 1;
        int b = 1;
        while (a + b <= MAX) {
            int next = a + b;
            f.add(next);
            a = b;
            b = next;
        }
        StringBuilder sb = new StringBuilder();
        while (0 < T--) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            for (int i = f.size() - 1; 0 <= i; i--) {
                if (N < f.get(i)) continue;
                list.add(f.get(i));
                N -= f.get(i);
            }

            for (int i = list.size() - 1; 0 <= i; i--) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}