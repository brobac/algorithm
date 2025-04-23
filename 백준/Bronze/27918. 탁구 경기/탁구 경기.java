import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int d = 0;
        int p = 0;
        for (int i = 0; i < N; i++) {
            if (br.readLine().equals("D")) {
                d++;
            } else {
                p++;
            }

            if (Math.abs(d - p) == 2) break;
        }

        System.out.println(d + ":" + p);
    }
}
