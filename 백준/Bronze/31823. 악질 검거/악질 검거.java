import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int maxLength = 0;
            int length = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (st.nextToken().equals("*")) {
                    length = 0;
                    continue;
                }
                length++;
                maxLength = Math.max(maxLength, length);
            }

            set.add(maxLength);
            sb.append(maxLength).append(" ").append(st.nextToken()).append("\n");
        }

        System.out.println(set.size());
        System.out.println(sb);
    }
}
