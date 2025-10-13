import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] b = new long[82];
        b[1] = 1;
        b[2] = 1;
        for (int i = 3; i <= 81; i++) {
            b[i] = b[i - 2] + b[i - 1];
        }

        int N = Integer.parseInt(br.readLine()) + 1;
        System.out.println(b[N - 1] * 4 + b[N - 2] * 2);
    }
}