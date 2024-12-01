import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long gcd(long b, long a) {
        if (a == 0) return 1;
        if (b % a == 0) return a;
        return gcd(a, b % a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long num = (long) Math.ceil(Math.sqrt(a + 1));
        long count = 0;
        while (num * num <= b) {
            count++;
            num++;
        }
        long range = b - a;
        long gcd = gcd(range, count);
        if (count == 0) {
            System.out.println(0);
        } else {
            System.out.println((count / gcd) + "/" + (range / gcd));

        }
    }
}