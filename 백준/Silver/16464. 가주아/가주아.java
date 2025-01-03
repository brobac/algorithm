import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        tc:
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(br.readLine());
            while (K != 1) {
                if (K % 2 == 1) {
                    sb.append("Gazua\n");
                    continue tc;
                }
                K /= 2;
            }
            sb.append("GoHanGang\n");
        }

        System.out.println(sb);
    }
}