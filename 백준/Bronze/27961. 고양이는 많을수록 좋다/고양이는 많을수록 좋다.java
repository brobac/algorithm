import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }
        int result = 1;

        long num = 1;
        while (num < N) {
            num *= 2;
            result++;
        }
        System.out.println(result);
    }
}