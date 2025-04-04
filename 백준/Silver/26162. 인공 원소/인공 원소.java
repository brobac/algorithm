import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[119];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < 119; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 119; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine());
            if (v <= 2) {
                sb.append("No\n");
                continue;
            }
            if (v % 2 == 0) {
                sb.append("Yes\n");
                continue;
            }
            sb.append(isPrime[v - 2] ? "Yes\n" : "No\n");
        }

        System.out.println(sb);
    }
}