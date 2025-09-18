import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long minX = Integer.MIN_VALUE;
        long maxX = Integer.MAX_VALUE;
        long minY = Integer.MIN_VALUE;
        long maxY = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            switch (d) {
                case "L": {
                    maxX = Math.min(maxX, x - 1);
                    break;

                }
                case "R": {

                    minX = Math.max(minX, x + 1);
                    break;
                }
                case "U": {
                    minY = Math.max(minY, y + 1);
                    break;
                }
                case "D": {
                    maxY = Math.min(maxY, y - 1);
                    break;


                }
            }

        }

        if (minX == Integer.MIN_VALUE || maxX == Integer.MAX_VALUE || minY == Integer.MIN_VALUE || maxY == Integer.MAX_VALUE) {
            System.out.println("Infinity");
        } else {
            BigInteger x = new BigInteger(Long.toString(maxX - minX + 1));
            BigInteger y = new BigInteger(Long.toString(maxY - minY + 1));
            System.out.println(x.multiply(y));
        }
    }
}
