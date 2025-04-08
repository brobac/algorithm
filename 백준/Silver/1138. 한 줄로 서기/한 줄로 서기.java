import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] result = new int[N];
        number:
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());

            int emptyCount = 0;
            for (int j = 0; j < N; j++) {
                if (emptyCount == v && result[j] == 0) {
                    result[j] = i + 1;
                    continue number;
                }
                if (result[j] == 0) {
                    emptyCount++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v : result) {
            sb.append(v).append(" ");
        }

        System.out.println(sb);
    }
}