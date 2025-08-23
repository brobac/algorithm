import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int N = Integer.parseInt(br.readLine());
        boolean[] current = new boolean[N];
        boolean[] target = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            target[i] = st.nextToken().equals("1");
        }

        for (int i = 0; i < N; i++) {
            if (current[i] == target[i]) continue;
            result++;
            current[i] = !current[i];

            if (i + 1 < N) {
                current[i + 1] = !current[i + 1];
            }

            if (i + 2 < N) {
                current[i + 2] = !current[i + 2];
            }
        }


        System.out.println(result);
    }
}
