import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N < 3) {
            System.out.println(1);
            return;
        }
        long a = 1;
        long b = 1;
        long result = 2;
        for (int i = 4; i <= N; i++) {
            a = b;
            b = result;
            result = a + b;
        }
        System.out.println(result);
    }
}