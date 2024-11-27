import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());

        if (N < 10) {
            System.out.println(N);
            return;
        }

        long sum = 0;
        long num = N;
        int length = 0;
        long temp = N;
        while (10 <= temp) {
            length++;
            temp /= 10;
        }

        do {
            long d = num % 10;
            num /= 10;
            num += d * Math.pow(10, length);
            sum += num;
        } while (num != N);

        System.out.println(sum);

    }
}