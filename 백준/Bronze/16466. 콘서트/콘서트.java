import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] sold = new boolean[N + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            if (N < A) continue;
            sold[A] = true;
        }
        for (int i = 1; i <= N + 1; i++) {
            if (!sold[i]) {
                System.out.println(i);
                return;
            }
        }
    }
}