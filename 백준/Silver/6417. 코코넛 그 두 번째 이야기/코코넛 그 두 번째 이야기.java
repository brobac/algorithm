import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        tc:
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == -1) break;

            find:
            for (int v = N; 1 < v; v--) {
                int num = N;
                for (int i = 0; i < v; i++) {
                    num--;
                    if (num % v != 0) continue find;
                    num -= num / v;
                }
                if (num % v == 0) {
                    sb.append(N).append(" coconuts, ").append(v).append(" people and 1 monkey\n");
                    continue tc;
                }
            }

            sb.append(N).append(" coconuts, no solution\n");


        }

        System.out.println(sb);
    }
}