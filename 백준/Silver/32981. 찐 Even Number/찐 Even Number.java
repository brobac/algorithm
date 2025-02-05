import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static final long MOD = 1000000007;

    static Map<Long, Long> map = new HashMap<>();

    static long solution(long n) {
        if (n == 1) return 5;

        return (4 * power(5, n - 1)) % MOD;
    }

    static long power(long a, long b) {
        if (b == 1) return a;

        long half = power(a, b / 2) % MOD;

        if (b % 2 == 0) {
            return (half * half) % MOD;
        } else {
            return (((a * half) % MOD) * half) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int Q = Integer.parseInt(br.readLine());

        for (int q = 0; q < Q; q++) {
            long N = Long.parseLong(br.readLine());

            sb.append(solution(N)).append("\n");

        }

        System.out.println(sb);
    }
}