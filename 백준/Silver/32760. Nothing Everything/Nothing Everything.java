import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] count = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            count[Math.max(a, b)]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (count[i] == 0) {
                sb.append("N");
            } else if (count[i] != i - 1) {
                System.out.println(-1);
                return;
            } else {
                sb.append("E");
            }
        }
        System.out.println(sb);
    }
}