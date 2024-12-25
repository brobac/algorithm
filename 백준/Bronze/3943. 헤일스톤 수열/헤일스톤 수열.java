import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int result = Integer.parseInt(br.readLine());
            int next = result;
            while (next != 1) {
                if (next % 2 == 0) {
                    next /= 2;
                } else {
                    next = next * 3 + 1;
                    result = Math.max(result, next);
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}