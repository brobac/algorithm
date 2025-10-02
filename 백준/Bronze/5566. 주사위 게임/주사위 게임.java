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

        int[] board = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        int location = 1;
        int count = 1;
        for (int i = 0; i < M; i++) {
            location += Integer.parseInt(br.readLine());
            if (N <= location) {
                System.out.println(count);
                return;
            }

            location += board[location];
            if (N <= location) {
                System.out.println(count);
                return;
            }
            count++;
        }
    }
}
