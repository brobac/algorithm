import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 0){
            System.out.println(0);
            return;
        }
        BigInteger[] fibo = new BigInteger[N + 1];
        fibo[0] = new BigInteger("0");
        fibo[1] = new BigInteger("1");
        for (int i = 2; i <= N; i++) {
            fibo[i] = fibo[i - 2].add(fibo[i - 1]);
        }
        System.out.println(fibo[N]);
    }

}