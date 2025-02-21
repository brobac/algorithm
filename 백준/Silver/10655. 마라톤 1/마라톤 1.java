import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] checkpoints = new int[N][2];
        int maxDistance = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            checkpoints[i][0] = Integer.parseInt(st.nextToken());
            checkpoints[i][1] = Integer.parseInt(st.nextToken());

        }

        int saveDistance = 0;

        for (int i = 1; i < N - 1; i++) {

            int prev = distance(checkpoints[i - 1][0], checkpoints[i - 1][1], checkpoints[i][0], checkpoints[i][1]);
            int next = distance(checkpoints[i][0], checkpoints[i][1], checkpoints[i + 1][0], checkpoints[i + 1][1]);
            int skip = distance(checkpoints[i - 1][0], checkpoints[i - 1][1], checkpoints[i + 1][0], checkpoints[i + 1][1]);

            maxDistance += prev;

            int save = prev + next - skip;
            saveDistance = Math.max(saveDistance, save);

        }

        maxDistance += distance(checkpoints[N - 2][0], checkpoints[N - 2][1], checkpoints[N - 1][0], checkpoints[N - 1][1]);

        System.out.println(maxDistance - saveDistance);

    }
}
