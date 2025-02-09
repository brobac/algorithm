import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int n = 1;
        int count = 0;
        while (count + n < A) {
            count += n;
            n++;
        }

        int remain = n - (A - count - 1);
        count = A - 1;

        while (count + remain <= B) {
            result += remain * n;
            count += remain;
            n++;
            remain = n;
        }

        result += n * (B - count);

        System.out.println(result);
    }
}