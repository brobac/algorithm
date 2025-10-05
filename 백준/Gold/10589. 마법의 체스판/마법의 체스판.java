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


        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int r = 2; r <= N; r += 2) {
            count++;
            sb.append(r).append(" ").append(1).append(" ").append(r).append(" ").append(M).append("\n");
        }
        for (int c = 2; c <= M; c += 2) {
            count++;
            sb.append(1).append(" ").append(c).append(" ").append(N).append(" ").append(c).append("\n");
        }

        System.out.println(count);
        System.out.println(sb);
    }
}