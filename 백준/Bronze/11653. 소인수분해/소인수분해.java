import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[N + 1];

        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= N; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j <= N; j += i) {
                isPrime[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        int v = 2;
        while (1 < N) {
            if (isPrime[v] && N % v == 0) {
                N /= v;
                sb.append(v).append("\n");
            } else {
                v++;
            }
        }
        System.out.println(sb);
    }
}