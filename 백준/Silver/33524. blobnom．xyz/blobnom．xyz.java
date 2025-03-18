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
        int[] count = new int[1000001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(st.nextToken())]++;
        }
        for (int i = 2; i < 1000001; i++) {
            count[i] += count[i - 1];
        }
        int size = 0;

        for (int i = 1; i < 1000001; i++) {
            while (3 * (size + 1) * size + 1 <= count[i]) {
                size++;
            }
            count[i] = size;
        }
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(count[Integer.parseInt(st.nextToken())]).append(" ");
        }
        System.out.println(sb);
    }
}