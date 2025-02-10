import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static final long X = 1_000_000_007;

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long power(long a, long b) {
        if (b == 1) {
            return a;
        }

        long half = power(a, b / 2);
        long result = half * half % X;
        if (b % 2 == 1) {
            result = result * a % X;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        long result = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long b = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long gcd = gcd(a, b);
            a /= gcd;
            b /= gcd;

            result += a * power(b, X - 2) % X;
            result %= X;
        }

        System.out.println(result);
    }

}