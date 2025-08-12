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
        int[] games = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            games[i] = Integer.parseInt(br.readLine());
        }
        int[] cost = new int[M];
        for (int i = 0; i < M; i++) {
            cost[i] = Integer.parseInt(br.readLine());

        }

        int[] count = new int[N + 1];

        for (int i = 0; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                if (games[j] <= cost[i]) {
                    count[j]++;
                    break;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (count[result] < count[i]) {
                result = i;
            }
        }
        System.out.println(result);
    }
}
