import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX = 500000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] p = new int[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            p[i] = i;
        }

        int count = 1;

        for (int i = 2; i * i <= N; i++) {
            if (p[i] == i) {
                count++;
                p[i] = count;
                for (int j = i * i; j <= N; j += i) {
                    p[j] = count;
                }
            }
        }
        for (int i = (int) Math.sqrt(N) + 1; i <= N; i++) {
            if (p[i] == i) {
                count++;
                p[i] = count;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");

        for (int i = 1; i <= N; i++) {
            sb.append(p[i]).append(" ");
        }

        System.out.println(sb);
    }
}