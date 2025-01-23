import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> success = new ArrayDeque<>();
        Deque<int[]> fail = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            int s = Integer.parseInt(br.readLine());
            if (s == 0) {
                success.push(i);
            } else {
                fail.push(new int[]{i, s});
            }
        }

        StringBuilder sb = new StringBuilder();

        if (success.size() == 0) {
            System.out.println(-1);
            return;
        }
        sb.append(success.pop()).append("\n");

        while (!fail.isEmpty()) {
            int[] cur = fail.pop();
            int problemNum = cur[0];
            int count = cur[1];

            if (success.size() < count - 1) {
                System.out.println(-1);
                return;
            }

            for (int i = 0; i < count - 1; i++) {
                sb.append(problemNum).append("\n");
                sb.append(success.pop()).append("\n");
            }
            sb.append(problemNum).append("\n").append(problemNum).append("\n");

        }

        if (!success.isEmpty()) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb);
    }
}