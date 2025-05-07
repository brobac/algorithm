import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long result = Long.parseLong(st.nextToken());
        long total = result;
        for (int i = 1; i < N; i++) {
            long s = Long.parseLong(st.nextToken());

            result = Math.max(result, s - total);
            total += s;
        }

        System.out.println(result);


    }
}