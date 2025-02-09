import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] prime = new int[5000001];
        prime[0] = prime[1] = -1;
        for (int i = 2; i <= 5000000; i++) {
            prime[i] = i;
        }

        int last = (int) Math.sqrt(5000000);
        for (int i = 2; i <= last; i++) {
            if (prime[i] != i) continue;
            for (int j = i * i; j <= 5000000; j += i) {
                if (prime[j] == j) {
                    prime[j] = i;
                }
            }
        }


        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(st.nextToken());

            while (1 < K) {
                sb.append(prime[K]).append(" ");
                K /= prime[K];
            }
            sb.append("\n");
        }


        System.out.println(sb);
    }
}