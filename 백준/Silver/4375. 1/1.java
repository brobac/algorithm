import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder result = new StringBuilder();
        while ((input = br.readLine()) != null && !input.equals("")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                sb.append("1");
            }
            BigInteger resultNum = new BigInteger(sb.toString());
            BigInteger n = new BigInteger(input);
            if (resultNum.compareTo(n) < 0) {
                resultNum = resultNum.multiply(new BigInteger("10")).add(new BigInteger("1"));
            }
            while (resultNum.mod(n).compareTo(new BigInteger("0")) != 0) {
                resultNum = resultNum.multiply(new BigInteger("10")).add(new BigInteger("1"));
            }

            result.append(resultNum.toString().length()).append("\n");
        }
        System.out.println(result);
    }
}
